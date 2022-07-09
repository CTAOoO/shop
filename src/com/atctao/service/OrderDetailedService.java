package com.atctao.service;

import com.atctao.pojo.OrderDetailed;

import java.util.List;

public interface OrderDetailedService {
    /**
     * OrderDetailed对象的填充
     * @param orderDetailed
     */
    public void registOrderDetailedService(OrderDetailed orderDetailed);

    public List<OrderDetailed> getAll();

    public void orderDetaileddelete(Integer orderId);
}
