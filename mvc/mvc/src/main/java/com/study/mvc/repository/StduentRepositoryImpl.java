package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StduentRepositoryImpl implements StudentRepository{
    List<String> studentList = List.of("전주환","서창현","예홍렬");
    @Override
    public Map<String,String> getStudentListAll() {
        Map<String,String> convert = new HashMap<>();
        for(int i=0;i<studentList.size();i++){
            convert.put("name" +(i+1),studentList.get(i));
        }
        System.out.println(convert);
        return convert;
    }

    @Override
    public String findStudentNameByIndex(int index) {
        String student = studentList.get(index);
        return student;
    }
}
