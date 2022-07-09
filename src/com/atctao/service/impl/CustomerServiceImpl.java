package com.atctao.service.impl;

import com.atctao.dao.CustomersDAO;
import com.atctao.dao.impl.CustomersDAOImpl;
import com.atctao.pojo.Customers;
import com.atctao.service.CustomerService;
import com.atctao.utils.JDBCUtils;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;

public class CustomerServiceImpl implements CustomerService {
    private CustomersDAO  customersDAO = new CustomersDAOImpl();
    @Override
    public void registCustomer(Customers customers) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(CustomersDAOImpl.class);
            System.out.println(conn);
            customersDAO.insert(conn,customers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public boolean existCustomerNumber(String number) {
        Connection conn = null;
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection1(CustomersDAOImpl.class);
            if(customersDAO.getCustomersByNumber(conn,number) == null){
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return flag;
    }

    @Override
    public Customers CustomerByNumber(String number) {
        Connection conn = null;
        Customers customers = new Customers();
        try {
            conn = JDBCUtils.getConnection1(CustomersDAOImpl.class);
            customers = customersDAO.getCustomersByNumber(conn,number);
            if (customers == null){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return customers;
    }

    @Override
    public Customers existCustomerLogin(String name, String password) {
        Connection conn = null;
        Customers customers = new Customers();
        try {
            conn = JDBCUtils.getConnection1(CustomersDAOImpl.class);
            customers = customersDAO.getCustomersByPassword(conn,name,password);
            if (customers == null){
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return customers;
    }
}
