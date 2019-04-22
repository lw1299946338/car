package com.example.car.lang;

/**
 *
 * F1开头为授信
 * F2开头为支付
 * F3开头为还款
 * @author liwei
 * @date 2019/3/13 1:56 PM
 */
public class ResErrMessage {

    static final String F10001 = "实例异常提示信息";

    public static final String ParamErrorCode = "F10002";
    public static final String ParamErrorMessage = "请输入15-20位阿拉伯数字银行卡";

    public static final String ParamEmptyCode = "F10003";
    public static final String ParamEmptyMessage = "不能为空";

    public static final String ParamSupportErrorCode = "F10004";
    public static final String ParamSupportErrorMessage = "暂不支持此卡，请更换其他银行卡";

}
