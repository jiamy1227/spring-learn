package com.jiamy.iocbean.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/23 11:18
 **/
@Component
@PropertySource("app.properties")
public class SmtpConfig {

    @Value("${smtp.host}")
    String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
