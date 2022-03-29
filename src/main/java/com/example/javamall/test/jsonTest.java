package com.example.javamall.test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.example.javamall.dto.MinioUploadDto;

public class jsonTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test() {
        String html = "{\"url\":\"This is url\", \"name\": \"This is name\"}";
        JSONObject jsonObject = JSONUtil.parseObj(html);
        MinioUploadDto minioUploadDto = JSONUtil.toBean(jsonObject, MinioUploadDto.class);
        System.out.println(minioUploadDto.getName());
        System.out.println(minioUploadDto.getUrl());
    }

    public static void test2() {
        String html = "{\"Url\":\"This is url\", \"Name\": \"This is name\"}";
        MinioUploadDto test =  JSON.parseObject(html, MinioUploadDto.class);
        System.out.println(test.toString());
    }
}
