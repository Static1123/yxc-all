package com.yxc.framework.pojo;

public class Singleton {
    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}