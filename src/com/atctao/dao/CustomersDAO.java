package com.atctao.dao;

import com.atctao.pojo.Customers;

import java.sql.Connection;
import java.util.List;

public interface CustomersDAO {
    // 将customer对象添加到数据库中
    void insert(Connection conn, Customers customers);
    // 通过对象修改
    void update(Connection conn,Customers customers);
    // 根据name删除指定的数据
    void deleteByName(Connection conn,String customerId);
    // 根据name查询得到相应的Customers对象
    Customers getCustomersByNumber(Connection conn,String customerNumber);
    // 根据name查询得到相应的Customers对象
    Customers getCustomersByPassword(Connection conn,String name,String customerPassword);
    // 查询表中所有记录构成的合集
    List<Customers> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
