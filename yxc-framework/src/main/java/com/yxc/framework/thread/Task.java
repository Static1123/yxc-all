package com.yxc.framework.thread;

public class Task implements Runnable {
    //    boolean running = true;
    volatile boolean running = true;
    int i = 0;

    @Override
    public void run() {
        while (running) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(10);
        task.running = false;
        System.out.println(task.i);
        System.out.println("程序停止");
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    public synchronized boolean getRunning() {
        return this.running;
    }
}
