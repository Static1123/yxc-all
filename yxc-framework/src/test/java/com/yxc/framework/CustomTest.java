package com.yxc.framework;

import com.yxc.framework.cache.LRUAbstractMap;
import com.yxc.framework.pojo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);

        LRUAbstractMap map = new LRUAbstractMap();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        System.out.println(map.toString());
    }
}