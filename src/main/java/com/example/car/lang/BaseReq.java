package com.example.car.lang;

import lombok.Getter;
import lombok.Setter;

/**
 * BaseReq
 *
 * @author yujiaxin
 * @date 2019/01/25
 */
@Getter
@Setter
public class BaseReq {
    private String busiNo;
    private String serviceId;
    private Object busiObject;
    
    public BaseReq(String busiNo, String serviceId) {
        this.busiNo = busiNo;
        this.serviceId = serviceId;
    }

}
