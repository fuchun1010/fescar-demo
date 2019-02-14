package com.tank.service.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.google.common.base.Preconditions;
import com.tank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author fuchun
 */
@Service
public class AccountServiceImpl implements AccountService {

  /**
   * @param name
   * @param money
   */
  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public void deduct(String name, double money) {
    Preconditions.checkArgument(Objects.nonNull(jdbcTemplate));
    System.out.println("account service xid is:" + RootContext.getXID());
    final String updateSql = "update tab_accounts set _salary = _salary - ? where _name = ?";
    int affectedRow = this.jdbcTemplate.update(updateSql, money, name);
    System.out.println("affectedRow = [" + affectedRow + "]");
  }


  @Qualifier("accountJdbcTemplate")
  @Autowired
  private JdbcTemplate jdbcTemplate;
}
