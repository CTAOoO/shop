package com.atctao.dao.impl;


import com.atctao.dao.BaseDAO;
import com.atctao.dao.OrderDetailedDAO;
import com.atctao.pojo.OrderDetailed;

import java.sql.Connection;
import java.util.List;

public class OrderDetailedDAOImpl extends BaseDAO<OrderDetailed> implements OrderDetailedDAO {
    @Override
    public void insert(Connection conn, OrderDetailed orderDetailed) {
        String sql = "insert into order_detailed values(?,?,?,?,?,?)";
        update(conn,sql,orderDetailed.getOrderDetailedId(),orderDetailed.getOrderId()
        ,orderDetailed.getCommodityId(),orderDetailed.getUnitPrice(),orderDetailed.getOrderNumber()
        ,orderDetailed.getMoney());
    }

    @Override
    public void update(Connection conn, OrderDetailed orderDetailed) {
        String sql = "update order_detailed set order_detailed_id = ?" +
                ",order_id = ?,commodity_id  = ?,unit_price = ?" +
                ",order_number = ?,money = ? where order_detailed_id = ?";
        update(conn,sql,orderDetailed.getOrderDetailedId(),orderDetailed.getOrderId()
                ,orderDetailed.getCommodityId(),orderDetailed.getUnitPrice(),orderDetailed.getOrderNumber()
                ,orderDetailed.getMoney(),orderDetailed.getOrderDetailedId());
    }

    @Override
    public void deleteByorderDetailedId(Connection conn, Integer orderDetailedId) {
        String sql = "delete from order_detailed where order_detailed_id = ?";
        update(conn,sql,orderDetailedId);
    }

    @Override
    public OrderDetailed getOrderByorderDetailedId(Connection conn, Integer orderDetailedId) {
        String sql = "select order_detailed_id orderDetailedId,order_id orderId" +
                ",commodity_id  commodityId,unit_price unitPrice"+
                ",order_number orderNumber,money where order_detailed_id = ?";
        OrderDetailed orderDetailed = queryForOne(conn,sql,orderDetailedId);
        return orderDetailed;
    }

    @Override
    public void deleteByorderId(Connection conn, Integer orderId) {
        String sql = "delete from order_detailed where order_id = ?";
        update(conn,sql,orderId);
    }

    @Override
    public List<OrderDetailed> getAll(Connection conn) {
        String sql = "select order_detailed_id orderDetailedId,order_id orderId" +
                ",commodity_id  commodityId,unit_price unitPrice"+
                ",order_number orderNumber,money from order_detailed";
        List<OrderDetailed> orderDetailedList = queryForList(conn,sql);
        return orderDetailedList;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from order_detailed";
        return getValue(conn,sql);
    }
}
