package com.atctao.dao;

import com.atctao.pojo.Order;

import java.sql.Connection;
import java.util.List;

public interface OrderDAO {
    // 将order对象添加到数据库中
    void insert(Connection conn, Order order);
    // 通过对象修改
    void update(Connection conn, Order order);
    // 根据id删除指定的数据
    void deleteById(Connection conn,Integer orderId);
    // 根据id查询得到相应的order对象
    Order getOrderById(Connection conn,Integer orderId);
    // 查询表中所有记录构成的合集
    List<Order> getOrderByNumber(Connection conn,String number);
    // 查询表中所有记录构成的合集
    List<Order> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
