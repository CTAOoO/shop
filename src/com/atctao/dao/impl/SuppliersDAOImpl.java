package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.SuppliersDAO;
import com.atctao.pojo.Brand;
import com.atctao.pojo.Suppliers;

import java.sql.Connection;
import java.util.List;

public class SuppliersDAOImpl extends BaseDAO<Suppliers> implements SuppliersDAO {
    @Override
    public void insert(Connection conn, Suppliers suppliers) {
        String sql = "insert into suppliers values(?,?,?,?)";
        update(conn,sql,suppliers.getVendorName(),suppliers.getContacts(),suppliers.getContactNumber(),suppliers.getVendorInformation());
    }

    @Override
    public void update(Connection conn, Suppliers suppliers) {
        String sql = "update suppliers set Vendor_name = ?,contacts = ?,contact_number = ?,Vendor_information = ? where Vendor_name = ?";
        update(conn,sql,suppliers.getVendorName(),suppliers.getContacts(),
                suppliers.getContactNumber(),suppliers.getVendorInformation(),suppliers.getVendorName());
    }

    @Override
    public void deleteByName(Connection conn, String VendorName) {
        String sql = "delete from suppliers where Vendor_name = ?";
        update(conn,sql,VendorName);
    }

    @Override
    public Suppliers getSupplierByName(Connection conn, String VendorName) {
        String sql = "select Vendor_name VendorName,contacts,contact_number contactNumber,Vendor_information VendorInformation from suppliers where Vendor_name = ?";
        Suppliers suppliers = queryForOne(conn,sql,VendorName);
        return suppliers;
    }

    @Override
    public List<Suppliers> getAll(Connection conn) {
        String sql = "select Vendor_name VendorName,contacts,contact_number contactNumber,Vendor_information VendorInformation from suppliers";
        List<Suppliers> suppliers = queryForList(conn,sql);
        return suppliers;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from suppliers";
        return getValue(conn, sql);
    }
}
