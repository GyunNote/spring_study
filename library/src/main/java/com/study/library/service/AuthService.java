package com.study.library.service;

import com.study.library.dto.SignupReqDto;
import com.study.library.entity.User;
import com.study.library.exception.SaveException;
import com.study.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean isDuplicatedByUsername(String username){
        return userMapper.findUserByUsername(username) != null;
    }
    @Transactional(rollbackFor = Exception.class)
    public void signup(SignupReqDto signupReqDto){
        int succesCount = 0;
        User user = signupReqDto.toEntity(passwordEncoder);

        succesCount += userMapper.saveUser(user);
        succesCount += userMapper.saveRole(user.getUserId());
        if(succesCount < 2){
            throw new SaveException();
        }
    }
}
