package com.atctao.dao;

import com.atctao.pojo.Norms;

import java.sql.Connection;
import java.util.List;

public interface NormsDAO {
    // 将norms对象添加到数据库中
    void insert(Connection conn, Norms norms);
    // 通过对象修改
    void update(Connection conn,Norms norms);
    // 根据name删除指定的数据
    void deleteByName(Connection conn,String sortId);
    // 根据Id查询得到相应的Norms对象
    Norms getNormsById(Connection conn,String sortId);
    // 查询表中所有记录构成的合集
    List<Norms> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
