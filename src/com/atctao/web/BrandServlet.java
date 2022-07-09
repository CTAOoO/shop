package com.atctao.web;

import com.atctao.pojo.Brand;
import com.atctao.service.BrandService;
import com.atctao.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrandServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        String brandName = req.getParameter("brandName");
        String brandAddress = req.getParameter("brandAddress");
        String brandPhoto = req.getParameter("brandPhoto");
        if (brandService.existBrandName(brandName)) {
            System.out.println("商品品牌名称"+brandName+"已存在");
            // 把错误信息回显到表单项信息，保存到request域中
            req.setAttribute("msg","商品品牌名称已存在");
            req.setAttribute("brandName",brandName);
            // 不可用 返回注册页面
            req.getRequestDispatcher("/pages/brand/brand_regist.jsp").forward(req,resp);
        } else {
            Brand brand = new Brand(brandName,brandAddress,brandPhoto);
            System.out.println(brand);
            brandService.registBrand(brand);
            // 可用 注册成功页面
            req.getRequestDispatcher("/pages/brand/regist_success.jsp").forward(req,resp);
        }
    }
}
