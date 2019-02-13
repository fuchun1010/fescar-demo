package com.tank.service.impl;


import com.tank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Override
  public void createOrder(String code, Double quality, Double unitPrice) {
    System.out.println("code = [" + code + "], quality = [" + quality + "], unitPrice = [" + unitPrice + "]");
  }

  @Qualifier("orderJdbcTemplate")
  @Autowired
  private JdbcTemplate jdbcTemplate;


}
