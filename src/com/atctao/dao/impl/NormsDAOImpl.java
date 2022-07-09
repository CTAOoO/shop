package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.NormsDAO;
import com.atctao.pojo.Norms;

import java.sql.Connection;
import java.util.List;

public class NormsDAOImpl extends BaseDAO<Norms> implements NormsDAO {

    @Override
    public void insert(Connection conn, Norms norms) {
        String sql = "insert into norms values(?,?,?)";
        update(conn,sql,norms.getSortId(),norms.getChengfen(),norms.getContent());
    }

    @Override
    public void update(Connection conn, Norms norms) {
        String sql = "update norms set sort_id = ?,chengfen = ?,content = ? where sort_id = ?";
        update(conn,sql,norms.getSortId(),norms.getChengfen(),norms.getContent(),norms.getSortId());
    }

    @Override
    public void deleteByName(Connection conn, String sortId) {
        String sql = "delete from norms where sort_id = ?";
        update(conn,sql,sortId);
    }

    @Override
    public Norms getNormsById(Connection conn, String sortId) {
        String sql = "select sort_id sortId,chengfen,content from norms where sort_id = ?";
        Norms norms = queryForOne(conn,sql,sortId);
        return norms;
    }

    @Override
    public List<Norms> getAll(Connection conn) {
        String sql = "select sort_id sortId,chengfen,content from norms";
        List<Norms> norms = queryForList(conn,sql);
        return norms;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from norms";
        return getValue(conn,sql);
    }
}
