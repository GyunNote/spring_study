package com.study.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Practice {
    private int id;
    private String name;
    private int age;
    private LocalDateTime createData;
}
