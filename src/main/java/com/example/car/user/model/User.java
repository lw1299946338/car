package com.example.car.user.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwei
 * @since 2019-02-27
 */
@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 金鹏卡号
     */
    @TableId()
    private String cardNumber;

    /**
     * 支付密码
     */
    private String payPassword;


    @Override
    protected Serializable pkVal() {
        return this.cardNumber;
    }

}
