package com.study.library.service;

import com.study.library.dto.SigninReqDto;
import com.study.library.dto.SignupReqDto;
import com.study.library.entity.User;
import com.study.library.exception.SaveException;
import com.study.library.jwt.JwtProvider;
import com.study.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public boolean isDuplicatedByUsername(String username){
        return userMapper.findUserByUsername(username) != null;
    }
    @Transactional(rollbackFor = Exception.class)
    public void signup(SignupReqDto signupReqDto){
        int succesCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);

        succesCount += userMapper.saveUser(user);
        succesCount += userMapper.saveRole(user.getUserId(),1);
        if(succesCount < 2){
            throw new SaveException();
        }
    }
    public String signin(SigninReqDto signinReqDto){
        User user = userMapper.findUserByUsername(signinReqDto.getUsername());
        if(user ==null){
            throw new UsernameNotFoundException("사용자 정보를 확인하세요");
        }if(!passwordEncoder.matches(signinReqDto.getPassword(),user.getPassword())){
            throw new BadCredentialsException("사용자 정보를 확인하세요");
        }
        System.out.println(user);

      // 1  Authentication authentication = new UsernamePasswordAuthenticationToken(user.toPrincipalUser(),"");

        return jwtProvider.generateToken(user);
    }
}
