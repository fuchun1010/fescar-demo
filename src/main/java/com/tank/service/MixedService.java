package com.tank.service;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.core.exception.TransactionException;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MixedService {


  @GlobalTransactional(name = "mixed transaction",timeoutMills = 600000000)
  public void createOrder(final String name, double salary, final String code, Double quality, Double unitPrice) throws Exception {
    System.out.println("MixedService xid = [" + RootContext.getXID()+ "]");
    this.accountService.deduct(name, salary);
    this.orderService.createOrder(code, quality, unitPrice);
    //throw  new Exception("xx");
  }

  @Autowired
  private AccountService accountService;

  @Autowired
  private OrderService orderService;
}
