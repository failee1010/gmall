package com.lee.gmall.service;

import com.lee.gmall.bean.OrderInfo;

public interface OrderService {
    String genTradeCode(String userId);

    boolean checkTradeCode(String tradeCode, String userId);

    void saveOrder(OrderInfo orderInfo);
}
