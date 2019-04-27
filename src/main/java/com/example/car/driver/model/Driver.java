package com.example.car.driver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
    private Integer drverAge;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public Integer getDrverAge() {
        return drverAge;
    }

    public void setDrverAge(Integer drverAge) {
        this.drverAge = drverAge;
    }

    public Integer getDriverYear() {
        return driverYear;
    }

    public void setDriverYear(Integer driverYear) {
        this.driverYear = driverYear;
    }

    public String getDriverCard() {
        return driverCard;
    }

    public void setDriverCard(String driverCard) {
        this.driverCard = driverCard;
    }

    public String getDriverLevel() {
        return driverLevel;
    }

    public void setDriverLevel(String driverLevel) {
        this.driverLevel = driverLevel;
    }

    public String getDriverCity() {
        return driverCity;
    }

    public void setDriverCity(String driverCity) {
        this.driverCity = driverCity;
    }

    public Integer getDriverCount() {
        return driverCount;
    }

    public void setDriverCount(Integer driverCount) {
        this.driverCount = driverCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Driver{" +
        "id=" + id +
        ", driverPhone=" + driverPhone +
        ", driverName=" + driverName +
        ", driverGender=" + driverGender +
        ", drverAge=" + drverAge +
        ", driverYear=" + driverYear +
        ", driverCard=" + driverCard +
        ", driverLevel=" + driverLevel +
        ", driverCity=" + driverCity +
        ", driverCount=" + driverCount +
        ", status=" + status +
        "}";
    }
}
