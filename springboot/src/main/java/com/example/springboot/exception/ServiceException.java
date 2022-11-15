package com.example.springboot.exception;

public class ServiceException extends RuntimeException {
    //不直接使用RuntimeException而是再定义一个ServiceException类，
    //原因是将AdminService.java中抛出的业务异常与系统自己的异常区分开
    private String Code;

    public String getCode() {
        return Code;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.Code = code;
    }
}
