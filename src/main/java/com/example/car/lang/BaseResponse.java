package com.example.car.lang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Object data;
    private String errCode;
    private String errMsg;

    public BaseResponse(String code ,String msg,Object data){
        this.errCode=code;
        this.errMsg = msg;
        this.data = data;
    }

    public BaseResponse() {

    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
