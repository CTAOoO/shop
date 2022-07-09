package com.atctao.web;

import com.atctao.pojo.OrderDetailed;
import com.atctao.service.OrderDetailedService;
import com.atctao.service.impl.OrderDetailedServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderDetailedServlet extends HttpServlet {
    private OrderDetailedService orderDetailedService = new OrderDetailedServiceImpl();

    public void setOrderDetailed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetailed> orderDetailedList = orderDetailedService.getAll();
        req.setAttribute("orderDetailedList",orderDetailedList);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
