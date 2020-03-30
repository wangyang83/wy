package com.springboot.tool.config;

import com.springboot.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王阳
 * @date 2020/3/25 17:21
 */
@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);
    @Bean
    public User logMethod() {
        LOG.info("==========print log==========");
        return new User();
    }

}
