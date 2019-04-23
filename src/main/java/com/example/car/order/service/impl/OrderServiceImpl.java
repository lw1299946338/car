package com.example.car.order.service.impl;

import com.example.car.order.model.Order;
import com.example.car.order.mapper.OrderMapper;
import com.example.car.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
