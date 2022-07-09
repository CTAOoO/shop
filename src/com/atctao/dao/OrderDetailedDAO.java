package com.atctao.dao;

import com.atctao.pojo.OrderDetailed;

import java.sql.Connection;
import java.util.List;

public interface OrderDetailedDAO {
    // 将orderDetailed对象添加到数据库中
    void insert(Connection conn, OrderDetailed orderDetailed);
    // 通过对象修改
    void update(Connection conn, OrderDetailed orderDetailed);
    // 根据orderDetailedId删除指定的数据
    void deleteByorderDetailedId(Connection conn,Integer orderDetailedId);
    // 根据orderDetailedId删除指定的数据
    void deleteByorderId(Connection conn,Integer orderId);
    // 根据orderDetailedId查询得到相应的orderDetailed对象
    OrderDetailed getOrderByorderDetailedId(Connection conn,Integer orderDetailedId);
    // 查询表中所有记录构成的合集
    List<OrderDetailed> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
