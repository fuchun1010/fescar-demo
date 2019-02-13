package com.tank.service;

import org.springframework.stereotype.Service;

/**
 * @author fuchun
 * @date 2019-02-13
 */

public interface OrderService {

  /**
   * @param code
   * @param quality
   * @param unitPrice
   */
  void createOrder(final String code, final Double quality, final Double unitPrice);
}
