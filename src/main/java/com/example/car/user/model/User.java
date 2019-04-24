package com.example.car.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 登录姓名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 支付密码
     */
    private String payPassword;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
