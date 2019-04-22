package com.example.car.enums;


/**
 *
 * 1开头为授信
 * 2开头为支付
 * 3开头为还款
 * @author liwei
 * @date 2019/3/13 1:56 PM
 */
public enum  ResErrMessageEnum {

    /**
     *小贷返回状态
     * */
    LoanSystemError("10000","小贷服务异常"),
    /**
     * 返回 APP success
     */
    AppSuccess("200","success"),
    /**
     *请求成功
     * */
    Success("200","成功"),

    /**
     *无效的白条token(还款时)
     * */
    InvalidToken("402","无效的token"),

    /**
     *无效的订单token(支付时)
     * */
    InvalidOrderToken("401","无效的订单token"),

    InvalidCardNumber("403","无效的金鹏卡号"),

    InvalidParam("10001","无效的参数"),

    InvalidOrder("10002","订单编号失效"),

    ParamError("10002","请输入15-20位阿拉伯数字银行卡"),

    ParamEmpty("10003","不能为空"),

    ParamSupportError("10004","暂不支持此卡，请更换其他银行卡"),

    ParamNoSupportError("1005","没有可支持的银行信息"),

    EmptyCredit("1006","获取授信信息有误"),

    AmountError("1007","金额格式有误"),

    AmountNotMatch("1008","还款金额与按期还款金额不符"),

    InvalidSmsCode("10008","短信验证码错误"),

    TimeOutSmsCode("10009","短信验证码超时"),

    CHECKPWDLOCK("10010","您的密码已经连续输错3次,请明天再试"),

    ValidSign("40001","验签失败"),
    DecryptError("40002","解密错误"),

    Bank4ElementError("2021","持卡人信息有误。"),
    PAYPWSERROR("20001","支付密码错误"),
    RISKERROR("20002","支用风控失败")
    ;


    /**
     * @author liwei
     * @date 2019/3/14 4:33 PM
     **/
    ResErrMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 编码
     * */
    private String code;

    /**
     * 异常信息
     * */
    private String message;

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
