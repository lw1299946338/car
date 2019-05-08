package com.example.car.car.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
@TableName("t_car")
@Data
@ToString
public class Car extends Model<Car> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名字
     */
    private String carName;

    /**
     * 类型
     */
    private String carType;

    /**
     * 金额
     */
    private BigDecimal price;

    /**
     * 品牌
     */
    private String carBrand;

    /**
     * 剩余
     */
    private Integer remaining;

    /**
     * 图片地址
     */
    private String carImage;

    /**
     * 状态
     */
    private String status;

    /**
     * 年检状态
     */
    private String carStatus;

    /**
     * 可乘坐人数
     */
    private String carRide;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 驾驶证等级
     */
    private String carLeval;

    /**
     * 出厂日日期
     */
    private String carReldate;


    /**
     * 购物车个数
     */
    @TableField(exist = false)
    private int count;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
