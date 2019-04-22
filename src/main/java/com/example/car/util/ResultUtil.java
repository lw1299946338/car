package com.example.car.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.car.enums.ResErrMessageEnum;
import com.example.car.lang.BaseResponse;


public class ResultUtil {
    /**
     * 请求成功，返回信息（带数据）
     *
     * @param object 返回的数据信息
     * @return
     */
    public static BaseResponse success(Object object) {
        BaseResponse result = new BaseResponse();
        result.setErrCode("200");
        result.setErrMsg("成功");
        result.setData(object);

        return result;
    }

    /**
     * 请求成功，返回信息（不带数据）
     *
     * @return
     */
    public static BaseResponse success() {
        return success(null);
    }

    /**
     * 请求失败，返回错误码及错误信息
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static BaseResponse error(String code, String msg) {
        BaseResponse result = new BaseResponse();
        result.setErrCode(code);
        result.setErrMsg(msg);

        return result;
    }

    /**
     * 请求失败，返回错误码及错误信息
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static BaseResponse error(String code, String msg, Object data) {
        BaseResponse result = new BaseResponse();
        result.setErrCode(code);
        result.setData(data);
        result.setErrMsg(msg);
        return result;
    }

    /**
     * @Authr Jerry (chenchen11@haihangyun.com)
     * @Date 2017/12/5 17:18
     * @Description 把响应的JSON字符串转换成ResultBody实体
     */
    public static BaseResponse getResultBody(String response) {
        JSONObject jsonObject = JSON.parseObject(response);
        BaseResponse body = JSONObject.toJavaObject(jsonObject, BaseResponse.class);
        return body;
    }

    public static BaseResponse error(ResErrMessageEnum invalidSmsCode) {
        BaseResponse result = new BaseResponse();
        result.setErrCode(invalidSmsCode.getCode());
        result.setErrMsg(invalidSmsCode.getMessage());
        return result;
    }
}
