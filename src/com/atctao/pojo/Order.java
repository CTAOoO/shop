package com.atctao.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;
    private String commodityId;
    private String customerName;
    private String customerNumber;
    private String customerAddress;
    private String postalCode;
    Date orderTime;
    private float orderAmount;

    public Order() {
    }

    public Order(Integer orderId, String commodityId, String customerName, String customerNumber
            , String customerAddress, String postalCode, Date orderTime, float orderAmount) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.postalCode = postalCode;
        this.orderTime = orderTime;
        this.orderAmount = orderAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", orderTime=" + orderTime +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
