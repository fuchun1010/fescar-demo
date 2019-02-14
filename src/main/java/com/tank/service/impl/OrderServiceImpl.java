package com.tank.service.impl;


import com.alibaba.fescar.core.context.RootContext;
import com.tank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@Service
public class OrderServiceImpl implements OrderService {

  /**
   * @param code
   * @param quality
   * @param unitPrice
   */
  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public void createOrder(String code, Double quality, Double unitPrice) {
    System.out.println("order service xid = [" + RootContext.getXID() + "]");
    final String insertSql = "insert into tab_status(_status, _code, _quality,_unit_price) values(?,?,?,?)";
    final int affectedRows = this.jdbcTemplate.update(insertSql, 0, code, quality, unitPrice);
    System.out.println("affectedRows = [" + affectedRows + "]");
  }

  @Qualifier("orderJdbcTemplate")
  @Autowired
  private JdbcTemplate jdbcTemplate;


}
