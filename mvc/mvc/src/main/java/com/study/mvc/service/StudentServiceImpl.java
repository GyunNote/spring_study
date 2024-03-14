package com.study.mvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String getStudentList() throws JsonProcessingException {
        Map<String,String> convertMap = studentRepository.getStudentListAll();
        ObjectMapper objectMapper = new ObjectMapper();
     return objectMapper.writeValueAsString(convertMap);
    }

    @Override
    public String getStudent(int index) {
        String studentId = studentRepository.findStudentNameByIndex(index);
        return studentId;
    }
}
