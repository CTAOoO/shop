package com.atctao.pojo;

public class OrderDetailed {
    private Integer orderDetailedId;
    private Integer orderId;
    private String commodityId;
    private Float unitPrice;
    private int orderNumber;
    private float money;

    public OrderDetailed() {
    }

    public OrderDetailed(Integer orderDetailedId, Integer orderId, String commodityId,
                         Float unitPrice, int orderNumber, float money) {
        this.orderDetailedId = orderDetailedId;
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.unitPrice = unitPrice;
        this.orderNumber = orderNumber;
        this.money = money;
    }

    public Integer getOrderDetailedId() {
        return orderDetailedId;
    }

    public void setOrderDetailedId(Integer orderDetailedId) {
        this.orderDetailedId = orderDetailedId;
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

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderDetailed{" +
                "orderDetailedId='" + orderDetailedId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", orderNumber=" + orderNumber +
                ", money=" + money +
                '}';
    }
}
