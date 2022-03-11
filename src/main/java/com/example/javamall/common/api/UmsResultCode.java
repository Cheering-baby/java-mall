package com.example.javamall.common.api;

public enum UmsResultCode implements IErrorCode {
    USERNAME_REQUIRED(001, "USERNAME REQUIRED"),
    PASSWORD_REQUIRED(002, "PASSWORD REQUIRED")
    ;
    private long code;
    private String message;

    private static final String MODEL_NAME = "APP-UMS-";

    UmsResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return MODEL_NAME + this.code;
    }

    @Override
    public String getMessage() {
        return  this.message;
    }
}
