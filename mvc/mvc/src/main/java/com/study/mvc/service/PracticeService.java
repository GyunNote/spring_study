package com.study.mvc.service;

import com.study.mvc.dto.InsertPrRespDto;
import com.study.mvc.dto.PrReqDto;
import com.study.mvc.entity.Practice;
import com.study.mvc.repository.PrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {
    @Autowired
    private PrRepository prRepository;

    public InsertPrRespDto insertPractice(PrReqDto prReqDto){

        Practice find = prRepository.findPracticeByName(prReqDto.getName());
        if(find != null){
            return InsertPrRespDto.builder()
                    .successStatus(false).build();

        }
        Practice practice =  Practice.builder()
                .name(prReqDto.getName())
                .age(prReqDto.getAge())
                .build();

        int successCount = prRepository.saving(practice);

        InsertPrRespDto insertPrRespDto = InsertPrRespDto.builder()
                .id(practice.getId())
                .name(practice.getName())
                .age(practice.getAge())
                .successStatus(successCount>0)
                .successCount(successCount)
                .build();
        return insertPrRespDto;
    }
}
