package com.study.mvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.repository.CarRepository;
import com.study.mvc.repository.CarRepositoryImpl;
import com.study.mvc.repository.CarRepositoryImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Component  이거 써도 되고 위에꺼 써도 됨 근데 위에껀 잘 보고
public class CarServiceImpl implements  CarService{
    @Autowired
    @Qualifier("a")
    private CarRepository carRepository;

    @Autowired
    //이거 할려고 @Bean 씀
    private ObjectMapper objectMapper;

    @Override
    public String getCarNames() {
        return String.join("," , carRepository.getCarNames());
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
