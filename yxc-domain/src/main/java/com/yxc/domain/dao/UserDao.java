package com.yxc.domain.dao;

import org.springframework.stereotype.Component;

/**
 * @author Static
 */
@Component("userDao")
public class UserDao {
    public void add() {
        System.out.println("-----UserDao------");
    }
}