package com.tank.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuchun
 * @date 2019-02-14
 */
@Configuration
public class FescarConfig {

  @Bean
  public GlobalTransactionScanner globalTransactionScanner() {
    GlobalTransactionScanner globalTransactionScanner = new GlobalTransactionScanner(this.applicationId, "receivables",1);
    return globalTransactionScanner;
  }

  @Value("${spring.application.name}")
  private String applicationId;
}
