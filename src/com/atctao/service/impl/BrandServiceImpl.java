package com.atctao.service.impl;

import com.atctao.dao.BrandDAO;
import com.atctao.dao.impl.BrandDAOImpl;
import com.atctao.pojo.Brand;
import com.atctao.service.BrandService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;

public class BrandServiceImpl implements BrandService {
    private BrandDAO brandDAO = new BrandDAOImpl();
    @Override
    public void registBrand(Brand brand) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(BrandDAOImpl.class);
            System.out.println(conn);
            brandDAO.insert(conn,brand);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public boolean existBrandName(String name) {
        Connection conn = null;
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection1(BrandDAOImpl.class);
            System.out.println(conn);
            if(brandDAO.getBrandByName(conn,name) == null){
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
