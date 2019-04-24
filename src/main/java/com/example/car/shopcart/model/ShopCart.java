package com.example.car.shopcart.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("t_shop_cart")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShopCart extends Model<ShopCart> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品id
     */
    private Integer carId;

    /**
     * 数量
     */
    private Integer carCount;

    /**
     * 创建时间
     */
    private Date creatTime;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    public int countAdd(){
        this.carCount++;
        return this.carCount;
    }

    public int countRemove(){
        this.carCount--;
        return this.carCount;
    }
}
