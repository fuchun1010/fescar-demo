package com.tank.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@Configuration
public class OrderDataSourceConfig {

  @Bean(initMethod = "init", destroyMethod = "close", name = "orderDs")
  public DruidDataSource initOrderDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    Preconditions.checkArgument(Objects.nonNull(username));
    final String[] parameters = new String[]{username, password, validationQuery, driver, url};
    Arrays.stream(parameters).forEach(p -> Preconditions.checkArgument(Objects.nonNull(p)));
    dataSource.setUsername(this.username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(this.driver);
    dataSource.setUrl(url);
    dataSource.setValidationQuery(validationQuery);
    dataSource.setInitialSize(this.initialSize);
    dataSource.setMinIdle(this.minIdle);
    dataSource.setMaxActive(this.maxActive);
    dataSource.setMaxWait(this.maxWait);
    dataSource.setTestWhileIdle(true);
    dataSource.setTestOnReturn(false);
    dataSource.setTestOnBorrow(false);
    return dataSource;
  }


  @Bean("orderProxyDs")
  public DataSource dataSource(@Qualifier("orderDs") DruidDataSource druidDataSource) {
    DataSourceProxy dataSourceProxy = new DataSourceProxy(druidDataSource);
    return dataSourceProxy;
  }

  @Bean("orderJdbcTemplate")
  public JdbcTemplate initAccountJdbcTemplate(@Qualifier("orderProxyDs") DataSource dataSource) {
    final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    return jdbcTemplate;
  }


  @Value("${spring.datasource.order.username}")
  private String username;

  @Value("${spring.datasource.order.password}")
  private String password;

  @Value("${spring.datasource.order.driverClassName}")
  private String driver;

  @Value("${spring.datasource.order.url}")
  private String url;

  @Value("${spring.datasource.order.validationQuery}")
  private String validationQuery;

  @Value("${spring.datasource.order.initialSize}")
  private int initialSize;

  @Value("${spring.datasource.order.minIdle}")
  private int minIdle;

  @Value("${spring.datasource.order.maxActive}")
  private int maxActive;

  @Value("${spring.datasource.order.maxWait}")
  private int maxWait;

}
