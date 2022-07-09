package com.atctao.service;


import com.atctao.pojo.Customers;

public interface CustomerService {
    /**
     * 注册用户
     * @param customers
     */
    public void registCustomer(Customers customers);

    /**
     * 检查电话号是否可用
     * @param number
     * @return 返回true表示已存在，返回false表示可用
     */
    public boolean existCustomerNumber(String number);

    /**
     * 返回客户登录对象
     * @param name
     * @param password
     * @return
     */
    public Customers existCustomerLogin(String name,String password);

    /**
     * 通过number返回客户对象
     * @param number
     * @return
     */
    public Customers CustomerByNumber(String number);

}
