package com.atctao.dao;

import com.atctao.pojo.Commodity;

import java.sql.Connection;
import java.util.List;

public interface CommodityDAO {
    // 将commodity对象添加到数据库中
    void insert(Connection conn, Commodity commodity);
    // 通过对象修改
    void update(Connection conn,Commodity commodity);
    // 根据name删除指定的数据
    void deleteByName(Connection conn,String commodityId);
    // 根据name查询得到相应的Commodity对象
    Commodity getCommodityById(Connection conn,String commodityId);
    // 查询表中所有记录构成的合集
    List<Commodity> getAll(Connection conn);
    // 查询特殊值
    Long getCount(Connection conn);
}
