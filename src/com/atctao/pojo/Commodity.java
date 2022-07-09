package com.atctao.pojo;

import java.awt.*;

public class Commodity {
    private String commodityId;
    private String brandName;
    private String VendorName;
    private String sortId;
    private String commodityName;
    private String commodityNorm;
    private String commodityModel;
    private String metering;
    private float marketValue;
    private float SalesPrice;
    private float CostPrice;
    private String commodityPhoto;
    private String commodityInformation;
    int stock;

    public Commodity() {
    }

    public Commodity(String commodityId, String brandName, String vendorName,
                     String sortId, String commodityName, String commodityNorm,
                     String commodityModel, String metering, float marketValue,
                     float salesPrice, float costPrice, String commodityPhoto,
                     String commodityInformation, int stock) {
        this.commodityId = commodityId;
        this.brandName = brandName;
        VendorName = vendorName;
        this.sortId = sortId;
        this.commodityName = commodityName;
        this.commodityNorm = commodityNorm;
        this.commodityModel = commodityModel;
        this.metering = metering;
        this.marketValue = marketValue;
        SalesPrice = salesPrice;
        CostPrice = costPrice;
        this.commodityPhoto = commodityPhoto;
        this.commodityInformation = commodityInformation;
        this.stock = stock;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityNorm() {
        return commodityNorm;
    }

    public void setCommodityNorm(String commodityNorm) {
        this.commodityNorm = commodityNorm;
    }

    public String getCommodityModel() {
        return commodityModel;
    }

    public void setCommodityModel(String commodityModel) {
        this.commodityModel = commodityModel;
    }

    public String getMetering() {
        return metering;
    }

    public void setMetering(String metering) {
        this.metering = metering;
    }

    public float getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
    }

    public float getSalesPrice() {
        return SalesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        SalesPrice = salesPrice;
    }

    public float getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(float costPrice) {
        CostPrice = costPrice;
    }

    public String getCommodityPhoto() {
        return commodityPhoto;
    }

    public void setCommodityPhoto(String commodityPhoto) {
        this.commodityPhoto = commodityPhoto;
    }

    public String getCommodityInformation() {
        return commodityInformation;
    }

    public void setCommodityInformation(String commodityInformation) {
        this.commodityInformation = commodityInformation;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId='" + commodityId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", VendorName='" + VendorName + '\'' +
                ", sortId='" + sortId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityNorm='" + commodityNorm + '\'' +
                ", commodityModel='" + commodityModel + '\'' +
                ", metering='" + metering + '\'' +
                ", marketValue=" + marketValue +
                ", SalesPrice=" + SalesPrice +
                ", CostPrice=" + CostPrice +
                ", commodityPhoto=" + commodityPhoto +
                ", commodityInformation='" + commodityInformation + '\'' +
                ", stock=" + stock +
                '}';
    }
}
