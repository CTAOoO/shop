package com.atctao.dao;

import com.atctao.pojo.Sort;

import java.sql.Connection;
import java.util.List;

public interface SortDAO {
    // 将sort对象添加到数据库中
    void insert(Connection conn, Sort sort);
    // 通过对象修改
    void update(Connection conn,Sort sort);
    // 根据name删除指定的数据
    void deleteById(Connection conn,String sortId);
    // 根据name查询得到相应的sort对象
    Sort getSortById(Connection conn,String sortId);
    // 查询表中所有记录构成的合集
    List<Sort> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
