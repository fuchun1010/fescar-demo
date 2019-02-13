package com.tank.service.impl;

import com.tank.service.AccountService;
import org.springframework.stereotype.Service;

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
    System.out.println("name = [" + name + "], money = [" + money + "]");
  }
}
