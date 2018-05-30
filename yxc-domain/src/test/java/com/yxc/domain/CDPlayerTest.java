package com.yxc.domain;

import com.yxc.domain.config.CDPlayerConfig;
import com.yxc.domain.service.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testCDPlayer() {
        compactDisc.play();
    }
}