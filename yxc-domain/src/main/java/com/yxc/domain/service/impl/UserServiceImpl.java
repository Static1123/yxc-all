package com.yxc.domain.service.impl;

import com.yxc.domain.dao.UserDao;
import com.yxc.domain.service.UserService;

import javax.annotation.Resource;

/**
 * @author Static
 */
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public void add() {
        System.out.println("-----UserServiceImpl add------");
        userDao.add();
    }
}