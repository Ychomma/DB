package com.example.springboot.controller.request;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

@Data
public class UserPageRequest extends BaseRequest {
    private String name;
    private String phone;
}
