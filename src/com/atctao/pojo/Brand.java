package com.atctao.pojo;

import java.awt.*;

public class Brand {
    private String brandName;
    private String brandAddress;
    private String brandPhoto;
    public Brand() {
    }

    public Brand(String brandName, String brandAddress, String brandPhoto) {
        this.brandName = brandName;
        this.brandAddress = brandAddress;
        this.brandPhoto = brandPhoto;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }

    public String getBrandPhoto() {
        return brandPhoto;
    }

    public void setBrandPhoto(String brandPhoto) {
        this.brandPhoto = brandPhoto;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                ", brandAddress='" + brandAddress + '\'' +
                ", brandPhoto='" + brandPhoto + '\'' +
                '}';
    }
}
