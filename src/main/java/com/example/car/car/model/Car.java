package com.example.car.car.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
@TableName("car")
@Data
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
     * 可乘坐人数
     */
    private String carRide;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Car{" +
        "id=" + id +
        ", carName=" + carName +
        ", carType=" + carType +
        ", price=" + price +
        ", carBrand=" + carBrand +
        ", remaining=" + remaining +
        ", carImage=" + carImage +
        ", status=" + status +
        "}";
    }
}
