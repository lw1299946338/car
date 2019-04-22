package com.example.car;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program stages
 * @description:
 * @author: liwei
 * @create: 2019/2/28 3:15 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("application-dev.properties")
@Slf4j
public class BaseTest {
}
