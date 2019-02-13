package com.tank.service.impl;

import com.google.common.base.Preconditions;
import com.tank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
  public void deduct(String name, double money) {
    Preconditions.checkArgument(Objects.nonNull(jdbcTemplate));
    System.out.println("name = [" + name + "], money = [" + money + "]");
  }


  @Qualifier("accountJdbcTemplate")
  @Autowired
  private JdbcTemplate jdbcTemplate;
}
