package com.atctao.pojo;

import java.awt.*;

public class Sort {
    private String sortId;
    private String sortName;
    private String sortPhoto;

    public Sort() {
    }

    public Sort(String sortId, String sortName, String sortPhoto) {
        this.sortId = sortId;
        this.sortName = sortName;
        this.sortPhoto = sortPhoto;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortPhoto() {
        return sortPhoto;
    }

    public void setSortPhoto(String sortPhoto) {
        this.sortPhoto = sortPhoto;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sortId='" + sortId + '\'' +
                ", sortName='" + sortName + '\'' +
                ", sortPhoto=" + sortPhoto +
                '}';
    }
}
