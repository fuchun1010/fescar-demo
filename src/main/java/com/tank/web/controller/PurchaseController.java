package com.tank.web.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.tank.service.AccountService;
import com.tank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * @author fuchun
 * @date 2019-02-13
 */
@Controller
@RequestMapping("/v1")
public class PurchaseController {

  @PostMapping("/purchase")
  public ResponseEntity<Map<String, Object>> createOrder(@RequestBody final Map<String, Object> request) {
    final Map<String, Object> response = Maps.newHashMap();
    System.out.println("request size = [" + request.size() + "]");
    response.putIfAbsent("status", "ok");

    Preconditions.checkArgument(Objects.nonNull(this.orderService));
    final String[] parameters = new String[]{"code", "quality", "unitPrice"};

    Arrays.stream(parameters).forEach(p -> Preconditions.checkArgument(Objects.nonNull(request.get(p))));

    final String code = (String) request.get("code");
    final Double quality = Double.parseDouble(request.get("quality").toString());
    final Double unitPrice = Double.parseDouble(request.get("unitPrice").toString());
    final String name = (String) request.get("name");
    final Double money = quality * unitPrice;


    this.orderService.createOrder(code, quality, unitPrice);

    this.accountService.deduct(name, money);

    return ResponseEntity.ok(response);
  }


  @Autowired
  private OrderService orderService;

  @Autowired
  private AccountService accountService;
}
