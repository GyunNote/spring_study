package com.study.mvc.repository;

import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//mybatis 시작하기에서 매핑된 SQl 구문 살펴보기에서 복사하고 resources 에서 만든 폴더에 파일 만들고 넣으면 됨
@Mapper
public interface DBStudyRepository {
    public int save(Study study);

    public Study findStudyById(int id);

    public Study findStudyByName(String name);

    public List<Study> findStudyAll();

    public int deleteById(int id);

    public int putById(Study study);

    public int patchById(Study study);

}
//1번