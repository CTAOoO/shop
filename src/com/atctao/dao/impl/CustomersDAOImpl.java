package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.CustomersDAO;
import com.atctao.pojo.Customers;

import java.sql.Connection;
import java.util.List;

public class CustomersDAOImpl extends BaseDAO<Customers> implements CustomersDAO {
    @Override
    public void insert(Connection conn, Customers customers) {
        String sql = "insert into customers values(?,?,?,?,?)";
        update(conn,sql,customers.getCustomerId(),customers.getCustomerName(),customers.getCustomerPassword()
                ,customers.getCustomerNumber(),customers.getCustomerAddress());
    }

    @Override
    public void update(Connection conn, Customers customers) {
        String sql = "update customers set customer_id = ?" +
                ",customer_name = ?,customer_password = ?" +
                ",customer_number = ?,customer_address = ? where customer_id = ?";
        update(conn,sql,customers.getCustomerId(),customers.getCustomerName()
                ,customers.getCustomerNumber(),customers.getCustomerAddress(),customers.getCustomerId());
    }

    @Override
    public void deleteByName(Connection conn, String customerId) {
        String sql = "delete from customers where customer_id = ?";
        update(conn,sql,customerId);
    }

    @Override
    public Customers getCustomersByNumber(Connection conn, String customerNumber) {
        String sql = "select customer_id customerId,customer_name customerName,customer_number customerNumber,customer_password customerPassword" +
                ",customer_address customerAddress from customers where customer_number = ?";
        Customers customers = queryForOne(conn,sql,customerNumber);
        System.out.println(customers);
        return customers;
    }

    @Override
    public Customers getCustomersByPassword(Connection conn, String name,String customerPassword) {
        String sql = "select customer_id customerId,customer_name customerName,customer_password customerPassword,customer_number customerNumber" +
                ",customer_address customerAddress from customers where customer_name = ? and customer_password = ?";
        Customers customers = queryForOne(conn,sql,name,customerPassword);
        System.out.println(customers);
        return customers;
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select customer_id customerId,customer_name customerName,customer_password customerPassword,customer_number customerNumber" +
                ",customer_address customerAddress from customers";
        List<Customers> customersList = queryForList(conn,sql);
        return customersList;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) form customers";
        return getValue(conn,sql);
    }
}
