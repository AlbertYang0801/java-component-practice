package com.albert.concurrentpractice.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfUtil {

    @Value("${docp.host}")
    private String docpHost;

    @Value("${docp.accountId}")
    private String docpAccountId;
    

}

