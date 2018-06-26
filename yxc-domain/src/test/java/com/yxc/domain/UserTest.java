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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.Map;

//SpringJUnit4ClassRunner 自动创建上下文对象
@RunWith(SpringJUnit4ClassRunner.class)
//激活当前配置文件
@ActiveProfiles("dev")
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

    @Test
    public void testReadFile() {
        readFileByLines("C:\\Users\\Administrator\\Desktop\\log4jd.log");
    }


    private static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            // 一次读入一行，直到读入null为文件结束
            System.out.println("==================================");
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if (tempString.contains("-thread-198")) {
                    System.out.println(tempString);
                    appendMethodA("bbbb.log", tempString + "\r\n");
                }
            }
            System.out.println("==================================");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.write(content.getBytes("UTF-8"));
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}