package com.example.learning;


import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LearningApplication {

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        List list1 = new ArrayList();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        List list2 = new ArrayList();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        List list3 = new ArrayList();
//        list3.add(1);
//        list3.add(2);
//        list3.add(3);
//        map.put("tjh1", list1);
//        map.put("tjh2", list2);
//        map.put("tjh3", list3);
        //String a = "JSONObject.toJSONString(map)"
            String a = "天津胡,唐继豪,体检合格";
            String[] b= a.split(",");
            String c = JSONObject.toJSONString(b);
            System.out.println(c);
            System.out.println(c.substring(1,c.length()-1));


//        SpringApplication.run(LearningApplication.class, args);
    }

}
