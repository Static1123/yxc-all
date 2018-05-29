package com.yxc.framework;

import com.yxc.framework.pojo.Book;

import static org.mockito.Mockito.*;

public class CustomTest2 {
    public static void main(String[] args) {
        Book book = mock(Book.class);
        book.setTitle("鲁滨逊漂流记");
        verify(book, times(1)).getTitle();
    }
}