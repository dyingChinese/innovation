package edu.wsyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import mybatis.mate.databind.ISensitiveStrategy;
import mybatis.mate.strategy.SensitiveStrategy;
/**
 * 敏感数据处理策略配置
 */
@Configuration
public class SensitiveStrategyConfig {

    /**
     * 注入脱敏策略
     */
//    @Bean
//    public ISensitiveStrategy sensitiveStrategy() {
//        // 自定义 testStrategy 类型脱敏处理
////        return new SensitiveStrategy().addStrategy("passwordStrategy", t -> t + "***test***");
//    }
}
