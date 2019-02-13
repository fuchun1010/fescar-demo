package com.tank.service;

/**
 * @author fuchun
 * @date 2019-02-13
 */
public interface AccountService {

  /**
   * @param name
   * @param money
   */
  void deduct(final String name, double money);
}
