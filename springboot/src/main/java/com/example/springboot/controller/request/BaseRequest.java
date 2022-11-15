package com.example.springboot.controller.request;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import lombok.Data;

@Data
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
