package com.tank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }
}
