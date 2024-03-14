package com.study.mvc.controller;

import com.study.mvc.dto.InsertPrRespDto;
import com.study.mvc.dto.PrReqDto;
import com.study.mvc.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBPRController {
    @Autowired
    private PracticeService practiceService;

    @PostMapping("/insert1")
    public ResponseEntity<?> insert(@RequestBody PrReqDto prReqDto){

        return ResponseEntity.ok(practiceService.insertPractice(prReqDto));
    }
}
