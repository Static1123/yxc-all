package com.yxc.framework.thread;

import java.util.Date;

/**
 * @author Static
 */
public class VolatileDemo {
    private static boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    System.out.println(new Date());
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}