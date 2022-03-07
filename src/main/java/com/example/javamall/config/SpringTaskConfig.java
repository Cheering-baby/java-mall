package com.example.javamall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringTaskConfig {
    private Logger LOGGER = LoggerFactory.getLogger(SpringTaskConfig.class);

    /**
     * cron表达式,扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        LOGGER.info("取消订单, 并根据sku编号释放锁定库存");
    }
}
