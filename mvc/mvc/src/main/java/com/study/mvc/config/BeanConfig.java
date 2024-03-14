package com.study.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

//Bean 수동등록(2개이상 등록가능)
@Configuration
public class BeanConfig {
    @Bean
    //objectmapper 같은 라이브러리에는 @component 를 달수 가 없어서 @bean 을 달아줘서 같은 역할을 하게 함
    //그리고 @Bean 을 쓰기 위해서 @configuration 써야함 @component 는 클래스 위에서만 쓸수 있음
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
