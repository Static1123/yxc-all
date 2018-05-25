package com.yxc.domain.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Static
 */
@Data
public class User implements Serializable {
    private String name;
    private int age;

    public void print() {
        System.out.println("------User print()------");
    }
}