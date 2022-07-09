package com.atctao.web;

import com.atctao.pojo.Norms;
import com.atctao.pojo.Sort;
import com.atctao.service.NormService;
import com.atctao.service.SortService;
import com.atctao.service.impl.NormServiceImpl;
import com.atctao.service.impl.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SortServlet extends HttpServlet {
    private SortService sortService = new SortServiceImpl();
    private NormService normService = new NormServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为UTF-8，从而解决post字符集乱码的问题
        // 在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        String sortId = req.getParameter("sortId");
        String sortName = req.getParameter("sortName");
        String sortPhoto = req.getParameter("sortPhoto");
        String normChengfen = req.getParameter("normChengfen");
        String normContent = req.getParameter("normContent");
        if (sortService.existSortId(sortId) || sortService.existSortName(sortName)){
            System.out.println("商品分类编号,或商品分类名称 "+sortId+","+sortName+"已存在");
            req.setAttribute("msg","商品分类编号,或商品分类名已存在");
            req.setAttribute("sortId",sortId);
            req.setAttribute("sortName",sortName);
            req.getRequestDispatcher("/pages/sort/sort_regist.jsp").forward(req,resp);
        }else {
            Sort sort = new Sort(sortId,sortName,sortPhoto);
            Norms norms = new Norms(sortId,normChengfen,normContent);
            System.out.println(sort);
            sortService.registSort(sort);
            normService.registNorm(norms);
            req.getRequestDispatcher("/pages/sort/regist_success.jsp").forward(req,resp);
        }
    }
}
