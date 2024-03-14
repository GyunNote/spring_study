package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import com.study.mvc.diAndIoc.IoCRepository;
import com.study.mvc.diAndIoc.IoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IoCController {
    @Autowired
    //@Component 가 달려있는 곳은 ioc 에 등록됨 그걸 @Autowired 를 달면 알아서 찾아서 옴 new 할필요 x
    private IoCService ioCService;

    @GetMapping("/ioc")
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
      String json = ioCService.getJson();

        return ResponseEntity.ok(json);
    }

}
