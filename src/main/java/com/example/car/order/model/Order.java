package com.example.car.order.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单详情
     */
    private String orderDetail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付状态
     */
    private String payStatus;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 应支付金额
     */
    private BigDecimal payableNumber;

    /**
     * 实际支付金额
     */
    private BigDecimal payNumber;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
