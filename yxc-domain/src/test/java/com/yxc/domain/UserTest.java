package com.yxc.domain;

import com.yxc.domain.dao.UserDao;
import com.yxc.domain.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:db.xml");

    public static void main(String[] args) {
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testUser() {
        UserDao userDao = context.getBean(UserDao.class);
        userDao.add();
    }
}