package com.tank.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@Configuration
@ConfigurationProperties("")
public class DataSourceConfig {


  @Bean(initMethod = "init", destroyMethod = "close", name = "orderDs")
  public DruidDataSource initOrderDataSource() {
    DruidDataSource druidDataSource = new DruidDataSource();
    Preconditions.checkArgument(Objects.nonNull(username));
    druidDataSource.setUsername(this.username);
    //TODO add some extra field value
    return druidDataSource;
  }


  @Value("${spring.datasource.order.username}")
  private String username;


}
