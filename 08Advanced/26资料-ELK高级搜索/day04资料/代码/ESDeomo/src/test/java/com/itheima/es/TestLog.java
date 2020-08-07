package com.itheima.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * creste by itheima.itcast
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLog.class);

    @Test
    public void testLog() {
        Random random = new Random();

        while (true) {
            int userId = random.nextInt(10);

            LOGGER.info("userId:{},send:{}", userId, "hello word");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
