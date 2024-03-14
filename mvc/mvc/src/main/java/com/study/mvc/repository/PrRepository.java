package com.study.mvc.repository;

import com.study.mvc.entity.Practice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrRepository {
    public int saving(Practice practice);

    public Practice findPracticeById(int id);
    public Practice findPracticeByName(String name);
}
