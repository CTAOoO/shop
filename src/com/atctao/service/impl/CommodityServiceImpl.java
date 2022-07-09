package com.atctao.service.impl;

import com.atctao.dao.CommodityDAO;
import com.atctao.dao.impl.BrandDAOImpl;
import com.atctao.dao.impl.CommodityDAOImpl;
import com.atctao.pojo.Commodity;
import com.atctao.service.CommodityService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class CommodityServiceImpl implements CommodityService {
    private CommodityDAO commodityDAO = new CommodityDAOImpl();
    @Override
    public Commodity commodityById(String id) {
        Connection conn = null;
        Commodity commodity = null;
        try {
            conn = JDBCUtils.getConnection1(CommodityDAOImpl.class);
            commodity = commodityDAO.getCommodityById(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return commodity;
    }

    @Override
    public List<Commodity> commodityALL() {
        Connection conn = null;
        List<Commodity> commodityList = null;
        try {
            conn = JDBCUtils.getConnection1(CommodityDAOImpl.class);
            commodityList = commodityDAO.getAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return commodityList;
    }

    @Override
    public void commodityregist(Commodity commodity) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(CommodityDAOImpl.class);
            commodityDAO.insert(conn,commodity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }

    @Override
    public boolean existCommodityId(String commodityId) {
        Connection conn = null;
        boolean flag = true;
        try {
            conn = JDBCUtils.getConnection1(BrandDAOImpl.class);
            System.out.println(conn);
            if(commodityDAO.getCommodityById(conn,commodityId) == null){
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
