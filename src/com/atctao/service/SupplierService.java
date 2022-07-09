package com.atctao.service;

import com.atctao.pojo.Customers;
import com.atctao.pojo.Suppliers;

public interface SupplierService {
    /**
     * 注册用户
     * @param suppliers
     */
    public void registSupplier(Suppliers suppliers);

    /**
     * 检查供应商名是否可用
     * @param name
     * @return 返回true表示已存在，返回false表示可用
     */
    public boolean existSupplierName(String name);

    /**
     * 检查电话号是否重复
     * @param number
     * @return
     */
    public boolean existSupplierNumber(String number);
}
