package com.atctao.service;

import com.atctao.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     * 订单生成
     * @param order
     */
    public void registOrder(Order order);

    /**
     * 查询全部订单
     * @return
     */
    public List<Order> orderByNumber(String number);
    public void orderDelete(Integer orderId);
}
