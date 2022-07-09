package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.OrderDAO;
import com.atctao.pojo.Order;

import java.sql.Connection;
import java.util.List;

public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public void insert(Connection conn, Order order) {
        String sql = "insert into `order` values(?,?,?,?,?,?,?,?)";
        update(conn,sql,order.getOrderId(),order.getCommodityId(),order.getCustomerName(),order.getCustomerNumber(),
                order.getCustomerAddress(),order.getPostalCode(),new java.sql.Date(order.getOrderTime().getTime())
                ,order.getOrderAmount());
    }

    @Override
    public void update(Connection conn, Order order) {
        String sql = "update `order` set order_id = ?,commodity_id = ?,customer_name = ?" +
                ",customer_number = ?,customer_address = ?" +
                ",postal_code = ?,order_time = ?,order_amount = ? where order_id = ?";
        update(conn,sql,order.getOrderId(),order.getCommodityId(),order.getCustomerName(),order.getCustomerNumber(),
                order.getCustomerAddress(),order.getPostalCode(),order.getOrderTime()
                ,order.getOrderAmount(),order.getOrderId());
    }

    @Override
    public void deleteById(Connection conn, Integer orderId) {
        String sql = "delete from `order` where order_id = ?";
        update(conn,sql,orderId);
    }


    @Override
    public List<Order> getOrderByNumber(Connection conn, String number) {
        String sql = "select order_id orderId,commodity_id commodityId,customer_name customerName" +
                ",customer_number customerNumber,customer_address customerAddress" +
                ",postal_code postalCode,order_time orderTime" +
                ",order_amount orderAmount from `order` where customer_number = ?";
        List<Order> orderList = queryForList(conn,sql,number);
        return orderList;
    }

    @Override
    public Order getOrderById(Connection conn, Integer orderId) {
        String sql = "select order_id orderId,commodity_id commodityId,customer_name customerName" +
                ",customer_number customerNumber,customer_address customerAddress" +
                ",postal_code postalCode,order_time orderTime,order_amount orderAmount from `order` where order_id = ?";
        Order order = queryForOne(conn,sql,orderId);
        return order;
    }

    @Override
    public List<Order> getAll(Connection conn) {
        String sql = "select order_id orderId,commodity_id commodityId,customer_name customerName" +
                ",customer_number customerNumber,customer_address customerAddress" +
                ",postal_code postalCode,order_time orderTime,order_amount orderAmount from `order`";
        List<Order> orders = queryForList(conn,sql);
        return orders;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from `order`";
        return getValue(conn,sql);
    }
}
