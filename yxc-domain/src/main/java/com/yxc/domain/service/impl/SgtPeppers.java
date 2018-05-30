package com.yxc.domain.service.impl;

import com.yxc.domain.service.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @author Static
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    /**
     * 播放
     */
    @Override
    public void play() {
        System.out.println("Playing [" + title + "] by [" + artist + "]");
    }
}