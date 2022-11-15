package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data //替换模板代码：在编译之后自动生成模板代码
public class Admin {
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updatetime;
    private boolean status;
}


//要使用数据库中的数据，在项目中必须有类与数据库中的表一一对应
