package com.example.javamall.common.exception;

import com.example.javamall.common.api.IErrorCode;
import org.springframework.util.StringUtils;

public class ApiExceptionAsserts {
    public static void hasText(String text, IErrorCode errorCode) {
        if (!StringUtils.hasText(text)) {
            throw new ApiException(errorCode);
        }
    }
}
