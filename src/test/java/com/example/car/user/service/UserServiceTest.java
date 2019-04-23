package com.example.car.user.service;

import com.example.car.BaseTest;
import com.example.car.user.model.User;
import com.example.car.util.StringUtils;
import lombok.ToString;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {


    @Autowired
    UserService userService;

    @Test
    public void t1(){
//        for (User user : userService.list()) {
//            user.setId(null);
//            user.insertOrUpdate();
//        }
    }
}