package com.atctao.service.impl;

import com.atctao.dao.SortDAO;
import com.atctao.dao.impl.SortDAOImpl;
import com.atctao.pojo.Sort;
import com.atctao.service.SortService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;

public class SortServiceImpl implements SortService {
    private SortDAO sortDAO = new SortDAOImpl();

    @Override
    public boolean existSortName(String name) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection1(SortDAOImpl.class);
            flag = true;
            if (sortDAO.getSortById(conn,name) == null){
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
        return flag;
    }

    @Override
    public void registSort(Sort sort) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(SortDAOImpl.class);
            sortDAO.insert(conn,sort);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Override
    public boolean existSortId(String id) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection1(SortDAOImpl.class);
            flag = true;
            if (sortDAO.getSortById(conn,id) == null){
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
        return flag;
    }
}
