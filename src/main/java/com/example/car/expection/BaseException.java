package com.example.car.expection;


import com.example.car.enums.ResErrMessageEnum;

public class BaseException extends RuntimeException {
    private String code;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public BaseException(String code, String message) {
        super(message);
        setCode(code);
    }

    public BaseException(ResErrMessageEnum e){
        super(e.getMessage());
        setCode(e.getCode());
    }

    public BaseException(String code, String message, Object data) {
        super(message);
        setCode(code);
        setData(data);
    }
}
