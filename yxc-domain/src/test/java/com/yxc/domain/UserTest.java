package com.yxc.domain;

import com.yxc.domain.dao.UserDao;
import com.yxc.domain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:db.xml"})
public class UserTest {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:db.xml");

    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testUser() {
//        UserDao userDao = context.getBean(UserDao.class);
        userDao.add();
    }
}