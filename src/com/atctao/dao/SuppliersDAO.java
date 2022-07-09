package com.atctao.dao;

import com.atctao.pojo.Brand;
import com.atctao.pojo.Suppliers;

import java.sql.Connection;
import java.util.List;

public interface SuppliersDAO {
    // 将suppliers对象添加到数据库中
    void insert(Connection conn, Suppliers suppliers);
    // 通过对象修改
    void update(Connection conn,Suppliers suppliers);
    // 根据name删除指定的数据
    void deleteByName(Connection conn,String VendorName);
    // 根据name查询得到相应的suppliers对象
    Suppliers getSupplierByName(Connection conn,String VendorName);
    // 查询表中所有记录构成的合集
    List<Suppliers> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
