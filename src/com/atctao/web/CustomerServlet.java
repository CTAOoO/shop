package com.atctao.web;

import com.atctao.pojo.Customers;
import com.atctao.service.CustomerService;
import com.atctao.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private CommodityServlet commodityServlet = new CommodityServlet();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        String customerName = req.getParameter("customerName");
        String customerPassword = req.getParameter("customerPassword");
        Customers customers = customerService.existCustomerLogin(customerName, customerPassword);
        if (customers!= null) {
            commodityServlet.setCommodity(req,resp);
            req.setAttribute("customerNumber",customers.getCustomerNumber());
            req.getRequestDispatcher("/pages/customer/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("customerName", customerName);
            req.getRequestDispatcher("/pages/customer/customer_login.jsp").forward(req, resp);
        }
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        String customerName = req.getParameter("customerName");
        String customerPassword = req.getParameter("customerPassword");
        String customerNumber = req.getParameter("customerNumber");
        String customerAddress = req.getParameter("customerAddress");
        // 检查用户电话号是否注册过
        if (customerService.existCustomerNumber(customerNumber)) {
            System.out.println("用户电话号" + customerNumber + "已存在");
            req.setAttribute("msg", "用户电话号已注册");
            req.setAttribute("customerName", customerName);
            // 不可用 返回注册页面
            req.getRequestDispatcher("/pages/customer/customer_regist.jsp").forward(req, resp);
        } else {
            Customers customers = new Customers(null, customerName, customerPassword, customerNumber, customerAddress);
            customerService.registCustomer(customers);
            // 可用 注册成功页面
            req.getRequestDispatcher("/pages/customer/regist_success.jsp").forward(req, resp);
        }
    }
    public void back(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        commodityServlet.setCommodity(req,resp);
        req.getRequestDispatcher("/pages/customer/login_success.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            login(req, resp);
        } else if ("regist".equals(action)) {
            regist(req, resp);
        }else if ("back".equals(action)){
            back(req,resp);
        }

    }


}
