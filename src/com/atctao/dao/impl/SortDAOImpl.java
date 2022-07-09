package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.SortDAO;
import com.atctao.pojo.Sort;

import java.sql.Connection;
import java.util.List;

public class SortDAOImpl extends BaseDAO<Sort> implements SortDAO {
    @Override
    public void insert(Connection conn, Sort sort) {
        String sql = "insert into sort values(?,?,?)";
        update(conn,sql,sort.getSortId(),sort.getSortName(),sort.getSortPhoto());
    }

    @Override
    public void update(Connection conn, Sort sort) {
        String sql = "update sort set sort_id = ?,sort_name = ?,sort_photo = ? where sort_id = ?";
        update(conn,sql,sort.getSortId(),sort.getSortName(),sort.getSortPhoto(),sort.getSortId());
    }

    @Override
    public void deleteById(Connection conn, String sortId) {
        String sql = "delete from sort where sort_id = ?";
        update(conn,sql,sortId);
    }

    @Override
    public Sort getSortById(Connection conn, String sortId) {
        String sql = "select sort_id sortId,sort_name sortName,sort_photo sortPhoto from sort where sort_id = ?";
        Sort sort = queryForOne(conn,sql,sortId);
        return sort;
    }

    @Override
    public List<Sort> getAll(Connection conn) {
        String sql = "select sort_id sortId,sort_name sortName,sort_photo sortPhoto from sort";
        List<Sort> sorts = queryForList(conn,sql);
        return sorts;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from sort";
        return getValue(conn, sql);
    }
}
