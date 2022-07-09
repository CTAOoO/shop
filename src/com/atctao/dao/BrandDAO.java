package com.atctao.dao;

import com.atctao.pojo.Brand;

import java.sql.Connection;
import java.util.List;

public interface BrandDAO {
    // 将brand对象添加到数据库中
    void insert(Connection conn, Brand brand);
    // 通过对象修改
    void update(Connection conn,Brand brand);
    // 根据name删除指定的数据
    void deleteByName(Connection conn,String name);
    // 根据name查询得到相应的brand对象
    Brand getBrandByName(Connection conn,String name);
    // 查询表中所有记录构成的合集
    List<Brand> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
