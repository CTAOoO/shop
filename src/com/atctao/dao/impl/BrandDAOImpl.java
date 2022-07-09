package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.BrandDAO;
import com.atctao.pojo.Brand;

import java.sql.Connection;
import java.util.List;

public class BrandDAOImpl extends BaseDAO<Brand> implements BrandDAO {

    @Override
    public void insert(Connection conn, Brand brand) {
        String sql = "insert into brand values(?,?,?)";
        update(conn,sql,brand.getBrandName(),brand.getBrandAddress(),brand.getBrandPhoto());
    }

    @Override
    public void update(Connection conn, Brand brand) {
        String sql = "update brand set brand_name = ?,brand_address = ?,brand_photo = ? where brand_name = ?";
        update(conn,sql,brand.getBrandName(),brand.getBrandAddress(),brand.getBrandPhoto(),brand.getBrandName());
    }

    @Override
    public void deleteByName(Connection conn, String name) {
        String sql = "delete from brand where brand_name = ?";
        update(conn,sql,name);
    }

    @Override
    public Brand getBrandByName(Connection conn, String name) {
        String sql = "select brand_name brandName , brand_address brandAddress , brand_photo brandPhoto from brand where brand_name = ?";
        Brand brand = queryForOne(conn, sql, name);
        return brand;
    }

    @Override
    public List<Brand> getAll(Connection conn) {
        String sql = "select brand_name brandName , brand_address brandAddress , brand_photo brandPhoto from brand";
        List<Brand> brands = queryForList(conn, sql);
        return brands;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from brand";
        return getValue(conn, sql);
    }
}
