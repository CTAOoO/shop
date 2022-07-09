package com.atctao.service.impl;

import com.atctao.dao.OrderDetailedDAO;
import com.atctao.dao.impl.OrderDetailedDAOImpl;
import com.atctao.pojo.OrderDetailed;
import com.atctao.service.OrderDetailedService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class OrderDetailedServiceImpl implements OrderDetailedService {
    private OrderDetailedDAO orderDetailedDAO = new OrderDetailedDAOImpl();
    @Override
    public void registOrderDetailedService(OrderDetailed orderDetailed) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDetailedDAOImpl.class);
            orderDetailedDAO.insert(conn,orderDetailed);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }

    @Override
    public void orderDetaileddelete(Integer orderId) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDetailedDAOImpl.class);
            orderDetailedDAO.deleteByorderDetailedId(conn,orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public List<OrderDetailed> getAll() {
        Connection conn = null;
        List<OrderDetailed> orderDetailedList = null;
        try {
            conn = JDBCUtils.getConnection1(OrderDetailedDAOImpl.class);
            orderDetailedList = orderDetailedDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return orderDetailedList;
    }
}
