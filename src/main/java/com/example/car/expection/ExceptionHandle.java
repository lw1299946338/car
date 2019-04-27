package com.example.car.expection;

import com.example.car.enums.ResErrMessageEnum;
import com.example.car.lang.BaseResponse;
import com.example.car.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeoutException;


/**
 * @Author  by yyj
 * @Date  2019/2/25.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResponse handleBase(BaseException e) {
        BaseException baseException = e;
        if (e.getCode().equals(ResErrMessageEnum.InvalidToken.getCode())){
            log.error("捕获异常: code=[{}],message=[{}]",baseException.getCode(),baseException.getMessage());
        }else{
            log.error("捕获异常: code=[{}],message=[{}]",baseException.getCode(),baseException.getMessage(),baseException);
        }
        return ResultUtil.error(baseException.getCode(), baseException.getMessage(), baseException.getData());

    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handle(Exception e) {
        log.error("捕获异常: ",e);
        return ResultUtil.error("500", "系统繁忙，请稍后重试");
    }



}
