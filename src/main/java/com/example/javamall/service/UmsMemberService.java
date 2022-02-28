package com.example.javamall.service;

import com.example.javamall.common.api.CommonResult;

/**
 * 会员管理Service
 * Created By daizhihong on 2022/02/28
 */

public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
