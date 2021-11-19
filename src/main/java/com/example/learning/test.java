package com.example.learning;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    private static TestEntity testEntity = new TestEntity();
    public static void main(String[] args) {
        Date a = new Date();
        System.out.println(a);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(a));

        String str = "ccc";
        String s = str+"bbb";
        testa();
        testb();

    }
    public static void testa(){

        testEntity.setAddress("localhost");
        testEntity.setName("nick");
    }

    public static void testb(){

        System.out.println(testEntity.getAddress());
        System.out.println(testEntity.getName());
    }

}
