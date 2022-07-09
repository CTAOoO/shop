package com.atctao.web;

import com.atctao.pojo.Suppliers;
import com.atctao.service.SupplierService;
import com.atctao.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SupplierServlet extends HttpServlet {
    private SupplierService supplierService = new SupplierServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        String supplierName = req.getParameter("supplierName");
        String supplierContact = req.getParameter("supplierContact");
        String supplierNumber = req.getParameter("supplierNumber");
        String supplierInformation = req.getParameter("supplierInformation");
        //检查供应商名是否注册过
        if (supplierService.existSupplierName(supplierName) || supplierService.existSupplierNumber(supplierNumber)){
            System.out.println("供应商名,或电话号 "+supplierName+","+supplierNumber+"已存在");
            req.setAttribute("msg","供应商名,或电话号已存在");
            req.setAttribute("supplierName",supplierName);
            req.setAttribute("supplierNumber",supplierNumber);
            req.getRequestDispatcher("/pages/supplier/supplier_regist.jsp").forward(req,resp);
        }else {
            Suppliers suppliers = new Suppliers(supplierName,supplierContact,supplierNumber,supplierInformation);
            System.out.println(suppliers);
            supplierService.registSupplier(suppliers);
            req.getRequestDispatcher("/pages/supplier/regist_success.jsp").forward(req,resp);
        }
    }
}
