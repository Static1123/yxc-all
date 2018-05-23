package com.yxc.framework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Static
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book extends Base {
    private String title;
    private String author;
    private String publishTime;
}