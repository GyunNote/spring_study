package com.study.mvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface StudentService {
    public String getStudentList() throws JsonProcessingException;
    public String getStudent(int index);
}
