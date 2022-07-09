package com.atctao.dao.impl;

import com.atctao.dao.BaseDAO;
import com.atctao.dao.CommodityDAO;
import com.atctao.pojo.Commodity;

import java.sql.Connection;
import java.util.List;

public class CommodityDAOImpl extends BaseDAO<Commodity>  implements CommodityDAO {
    @Override
    public void insert(Connection conn, Commodity commodity) {
        String sql = "insert into commodity values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(conn,sql,commodity.getCommodityId(),commodity.getBrandName(),
                commodity.getVendorName(),commodity.getSortId(),
                commodity.getCommodityName(),commodity.getCommodityNorm(),
                commodity.getCommodityModel(),commodity.getMetering(),
                commodity.getMarketValue(),commodity.getSalesPrice(),commodity.getCostPrice(),
                commodity.getCommodityPhoto(),commodity.getCommodityInformation(),commodity.getStock());
    }

    @Override
    public void update(Connection conn, Commodity commodity) {
        String sql = "update commodity set commodity_id = ?" +
                ",brand_name = ?,Vendor_name = ?,sort_id = ?" +
                ",commodity_name = ?,commodity_norm = ?" +
                ",commodity_model = ?,metering = ?,market_value = ?" +
                ",Sales_price = ?,Cost_price = ?,commodity_photo = ?" +
                ",commodity_information = ?,stock = ? where commodity_id = ?";
        update(conn,sql,commodity.getCommodityId(),commodity.getBrandName(),
                commodity.getVendorName(),commodity.getSortId(),
                commodity.getCommodityName(),commodity.getCommodityNorm(),
                commodity.getCommodityModel(),commodity.getMetering(),
                commodity.getMarketValue(),commodity.getSalesPrice(),commodity.getCostPrice(),
                commodity.getCommodityPhoto(),commodity.getCommodityInformation()
                ,commodity.getStock(),commodity.getCommodityId());
    }

    @Override
    public void deleteByName(Connection conn, String commodityId) {
        String sql = "delete from commodity where commodity_id = ?";
        update(conn,sql,commodityId);
    }

    @Override
    public Commodity getCommodityById(Connection conn, String commodityId) {
        String sql = "select commodity_id commodityId" +
                ",brand_name brandName,Vendor_name VendorName,sort_id sortId" +
                ",commodity_name commodityName,commodity_norm commodityNorm" +
                ",commodity_model commodityModel,metering,market_value marketValue" +
                ",Sales_price SalesPrice,Cost_price CostPrice,commodity_photo commodityPhoto" +
                ",commodity_information commodityInformation,stock from commodity where commodity_id = ?";
        Commodity commodity = queryForOne(conn,sql,commodityId);
        return commodity;
    }

    @Override
    public List<Commodity> getAll(Connection conn) {
        String sql = "select commodity_id commodityId" +
                ",brand_name brandName,Vendor_name VendorName,sort_id sortId" +
                ",commodity_name commodityName,commodity_norm commodityNorm" +
                ",commodity_model commodityModel,metering,market_value marketValue" +
                ",Sales_price SalesPrice,Cost_price CostPrice,commodity_photo commodityPhoto" +
                ",commodity_information commodityInformation,stock from commodity";
        List<Commodity> commodities = queryForList(conn,sql);
        return commodities;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from commodity";
        return getValue(conn,sql);
    }
}
