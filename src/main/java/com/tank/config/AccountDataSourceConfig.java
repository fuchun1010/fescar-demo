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
 * @date 2019
 */
@Configuration
public class AccountDataSourceConfig {

  @Bean(initMethod = "init", destroyMethod = "close", name = "accountDs")
  public DruidDataSource initAccountDataSource() {
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

  @Bean("accountProxyDs")
  public DataSource dataSource(@Qualifier("accountDs") DruidDataSource druidDataSource) {
    DataSourceProxy dataSourceProxy = new DataSourceProxy(druidDataSource);
    return dataSourceProxy;
  }

  @Bean("accountJdbcTemplate")
  public JdbcTemplate initAccountJdbcTemplate(@Qualifier("accountDs") DruidDataSource druidDataSource) {
    final JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);
    return jdbcTemplate;
  }


  @Value("${spring.datasource.account.username}")
  private String username;

  @Value("${spring.datasource.account.password}")
  private String password;

  @Value("${spring.datasource.account.driverClassName}")
  private String driver;

  @Value("${spring.datasource.account.url}")
  private String url;

  @Value("${spring.datasource.account.validationQuery}")
  private String validationQuery;

  @Value("${spring.datasource.account.initialSize}")
  private int initialSize;

  @Value("${spring.datasource.account.minIdle}")
  private int minIdle;

  @Value("${spring.datasource.account.maxActive}")
  private int maxActive;

  @Value("${spring.datasource.account.maxWait}")
  private int maxWait;
}
