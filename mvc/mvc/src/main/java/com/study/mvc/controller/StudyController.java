package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudyController {
    //MVC
    @GetMapping("/hello")
    public String helloPage(Model model){
        HelloModel helloModel = HelloModel.builder()
                .name1("1번")
                .name2("2번")
                .name3("3번")
                .build();
        model.addAttribute("h", helloModel);
        return "hello";
    }

    //REST
    @GetMapping("/test")
    @ResponseBody
    //body는 백엔드에서 데이터
    public List<Map<String,Object>> testpage(){

        List<Map<String,Object>> testObjs = new ArrayList<>();
        for (int i=0;i<=20;i++){
            Map<String,Object> testObj = new HashMap<>();
            testObj.put("z-id", i);
            testObj.put("name", i + "번 사람");
            testObj.put("age", i + 20);
            testObjs.add(testObj);
        }
        return testObjs;
    }
}

