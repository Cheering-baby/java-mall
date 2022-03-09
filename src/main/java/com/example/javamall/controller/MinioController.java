package com.example.javamall.controller;


import com.example.javamall.common.api.CommonResult;
import com.example.javamall.dto.MinioUploadDto;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/minio")
public class MinioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
      try{
          // 创建一个MinIO的客户端
          MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
          boolean isExist = minioClient.bucketExists(BUCKET_NAME);
          if(isExist) {
              LOGGER.info("存储桶已经存在");
          } else {
              // 创建存储桶并设置只读权限
              minioClient.makeBucket(BUCKET_NAME);
              minioClient.setBucketPolicy(BUCKET_NAME, "*.*", PolicyType.READ_ONLY);
          }
          String filename = file.getOriginalFilename();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          // 设置存储对象名称
          String objectName = filename;
          // 使用putObject上传一个文件到存储桶
          minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getContentType());
          LOGGER.info("文件上传成功");
          MinioUploadDto minioUploadDto = new MinioUploadDto();
          minioUploadDto.setName(filename);
          minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
          return CommonResult.success(minioUploadDto);
      } catch (Exception e) {
          LOGGER.info("上传发生错误: {}", e.getMessage());
      }
      return CommonResult.failed();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try{
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            minioClient.removeObject(BUCKET_NAME, objectName);
            return CommonResult.success(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }
}
