package com.example.car.order.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 订单编号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 订单详情
     */
    @TableField(value = "order_detail")
    private String orderDetail;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 支付状态
     */
    @TableField(value = "pay_status")
    private String payStatus;

    /**
     * 支付时间
     */
    @TableField(value = "pay_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date payTime;

    /**
     * 应支付金额
     */
    @TableField(value = "payable_number")
    private BigDecimal payableNumber;

    /**
     * 实际支付金额
     */
    @TableField(value = "pay_number")
    private BigDecimal payNumber;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
