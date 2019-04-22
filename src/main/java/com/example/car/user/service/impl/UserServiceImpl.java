package com.example.car.user.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.car.user.mapper.UserMapper;
import com.example.car.user.model.User;
import com.example.car.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liwei
 * @since 2019-02-27
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
