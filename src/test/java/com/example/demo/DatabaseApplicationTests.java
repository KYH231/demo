package com.example.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DatabaseApplicationTests {
    
    @Autowired
    private ApplicationContext context;

    
    @Autowired
    private SqlSessionFactory factory;

    @Test
    public void testByFactory() {
        try {
            System.out.println(">>>>>>>>>>>> factory");
            System.out.println(factory.toString());
            System.out.println(context.getBean("kdt"));
            System.out.println(">>>>>>>>>>>>>>>>>>>");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
