package com.imustacm.test;

import com.imustacm.dao.StockDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {


    @Test
    public void testDao()
    {

        ApplicationContext ap=new ClassPathXmlApplicationContext("spring.xml");
        StockDao stockDao = (StockDao) ap.getBean("stockDao");
        System.out.println(stockDao);



    }
}
