package com.example.javamall.dto;


import lombok.Data;

@Data
public class WebLog {
    private String description;
    private String username;
    private Long startTime;
    private Long spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;
}
