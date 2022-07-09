package com.atctao.service.impl;

import com.atctao.dao.NormsDAO;
import com.atctao.dao.impl.NormsDAOImpl;
import com.atctao.pojo.Norms;
import com.atctao.service.NormService;
import com.atctao.utils.JDBCUtils;

import java.sql.Connection;

public class NormServiceImpl implements NormService {
    private NormsDAO normsDAO = new NormsDAOImpl();

    @Override
    public void registNorm(Norms norms) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1(NormsDAOImpl.class);
            normsDAO.insert(conn, norms);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Override
    public Norms NormsByid(String sortId) {
        Connection conn = null;
        Norms norms = null;
        try {
            conn = JDBCUtils.getConnection1(NormsDAOImpl.class);
            norms = normsDAO.getNormsById(conn, sortId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
        return norms;
    }
}
