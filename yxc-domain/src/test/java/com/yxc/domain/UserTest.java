package com.yxc.domain;

import com.yxc.domain.dao.UserDao;
import com.yxc.domain.pojo.User;
import com.yxc.domain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:db.xml"})
public class UserTest {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:db.xml");

    @Autowired
    private UserDao userDao;

    @Resource(name = "jdbcTemplate1")
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    public static void main(String[] args) {
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.add();

        User user = (User) context.getBean("user");
        user.print();


    }

    @Test
    public void testUser() {
//        UserDao userDao = context.getBean(UserDao.class);
        userDao.add();
    }

    @Test
    public void testJDBC() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from `dw_user` limit 10");
        System.out.println(list);

        list = jdbcTemplate2.queryForList("select * from `a` limit 10");
        System.out.println(list);
    }
}