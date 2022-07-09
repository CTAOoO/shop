package com.atctao.service.impl;

import com.atctao.dao.SuppliersDAO;
import com.atctao.dao.impl.CustomersDAOImpl;
import com.atctao.dao.impl.SuppliersDAOImpl;
import com.atctao.pojo.Suppliers;
import com.atctao.service.SupplierService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;

public class SupplierServiceImpl implements SupplierService {
    private SuppliersDAO suppliersDAO = new SuppliersDAOImpl();
    @Override
    public void registSupplier(Suppliers suppliers) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(SuppliersDAOImpl.class);
            System.out.println(conn);
            suppliersDAO.insert(conn,suppliers);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public boolean existSupplierName(String name) {
        Connection conn = null;
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection1(SuppliersDAOImpl.class);
            System.out.println(conn);
            if(suppliersDAO.getSupplierByName(conn,name) == null){
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
    public boolean existSupplierNumber(String number) {
        Connection conn = null;
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection1(SuppliersDAOImpl.class);
            System.out.println(conn);
            if(suppliersDAO.getSupplierByName(conn,number) == null){
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return flag;
    }

}
