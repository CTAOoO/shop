package com.atctao.service.impl;

import com.atctao.dao.OrderDAO;
import com.atctao.dao.impl.OrderDAOImpl;
import com.atctao.pojo.Order;
import com.atctao.service.OrderService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    @Override
    public void registOrder(Order order) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDAOImpl.class);
            orderDAO.insert(conn,order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public void orderDelete(Integer orderId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDAOImpl.class);
            orderDAO.deleteById(conn,orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public List<Order> orderByNumber(String number) {
        Connection conn = null;
        List<Order> orderList = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDAOImpl.class);
            orderList = orderDAO.getOrderByNumber(conn,number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return orderList;
    }
}
