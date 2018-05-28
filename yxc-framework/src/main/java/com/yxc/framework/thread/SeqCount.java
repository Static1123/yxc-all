package com.yxc.framework.thread;

import com.yxc.framework.pojo.Book;

import java.util.Date;

/**
 * @author Static
 */
public class SeqCount {
    private static ThreadLocal<Book> seqCount = new ThreadLocal<Book>() {
        // 实现initialValue()
        @Override
        public Book initialValue() {
            Book book = new Book();
            book.setAuthor("Tom");
            book.setTitle("鲁宾逊漂流记");
            return book;
        }
    };

    public Book nextSeq() {
        Book book = seqCount.get();
        book.setPublishTime((new Date()).toString());
        seqCount.set(book);
        return seqCount.get();
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();
        SeqThread thread1 = new SeqThread(seqCount);
        SeqThread thread2 = new SeqThread(seqCount);
        SeqThread thread3 = new SeqThread(seqCount);
        SeqThread thread4 = new SeqThread(seqCount);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static class SeqThread extends Thread {
        private SeqCount seqCount;

        SeqThread(SeqCount seqCount) {
            this.seqCount = seqCount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " seqCount :" + seqCount.nextSeq().getPublishTime());
                try {
                    sleep(1000);
                } catch (Exception ex) {

                }
            }
        }
    }
}