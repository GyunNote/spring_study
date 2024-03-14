package com.study.mvc.controller;

import com.study.mvc.aop.annotation.TimeAspect;
import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.repository.DBStudyRepository;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto dbStudyReqDto){


        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto));

    }
    @GetMapping("/select/study/{id}")
    public ResponseEntity<?> selectStudy(@PathVariable int id){

        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }
    @GetMapping("/select/study")
    public ResponseEntity<?> selectStudy(@RequestParam String name){

        return ResponseEntity.ok(dbStudyService.findStudyByName(name));
    }
    @TimeAspect
    @GetMapping("select/studies")
    public ResponseEntity<?> selectStudyAll(){
        return ResponseEntity.ok(dbStudyService.findAll());
    }
    @DeleteMapping("delete/study/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable int id){

        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }
    //전체수정
    @PutMapping("put/study/{id}")
    public ResponseEntity<?> putStudy(@PathVariable int id, @RequestBody DBStudyReqDto dbStudyReqDto){

        return ResponseEntity.ok(dbStudyService.putById(id,dbStudyReqDto));
    }
    //부분수정
    @PatchMapping("patch/study/{id}")
    public ResponseEntity<?> updateStudy(@PathVariable int id, @RequestBody DBStudyReqDto dbStudyReqDto){

        return ResponseEntity.ok(dbStudyService.patchById(id,dbStudyReqDto));
    }
}//3번
