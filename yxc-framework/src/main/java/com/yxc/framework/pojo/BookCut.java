package com.yxc.framework.pojo;

public class BookCut {
    public void before() {
        System.out.println("BookCut before......");
    }

    public void after() {
        System.out.println("BookCut after......");
    }

    public void test() {
        System.out.println("BookCut test......");
    }
}