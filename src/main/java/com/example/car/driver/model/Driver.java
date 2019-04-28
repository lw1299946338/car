package com.example.car.driver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 司机表
 * </p>
 *
 * @author liwei
 * @since 2019-04-27
 */
@TableName("t_driver")
@ToString
@Data
public class Driver extends Model<Driver> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 司机手机号
     */
    private String driverPhone;

    /**
     * 司机名称
     */
    private String driverName;

    /**
     * 司机性别
     */
    private String driverGender;

    /**
     * 司机年龄
     */
    private Integer driverAge;

    /**
     * 司机驾龄
     */
    private Integer driverYear;

    /**
     * 司机驾驶证
     */
    private String driverCard;

    /**
     * 司机驾驶证级别
     */
    private String driverLevel;

    /**
     * 司机所在城市
     */
    private String driverCity;

    /**
     * 司机接单次数
     */
    private Integer driverCount;

    /**
     * 状态(0=可用,1=不可用)
     */
    private String status;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
