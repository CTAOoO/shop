package com.atctao.web;

import com.atctao.pojo.Customers;
import com.atctao.pojo.Order;
import com.atctao.pojo.OrderDetailed;
import com.atctao.service.CustomerService;
import com.atctao.service.OrderDetailedService;
import com.atctao.service.OrderService;
import com.atctao.service.impl.CustomerServiceImpl;
import com.atctao.service.impl.OrderDetailedServiceImpl;
import com.atctao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private OrderDetailedService orderDetailedService = new OrderDetailedServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private OrderDetailedServlet orderDetailedServlet = new OrderDetailedServlet();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commodityId = req.getParameter("commodityId");
        String customerNumber = req.getParameter("customerNumber");
        String commodityPrice = req.getParameter("commodityPrice");
        String orderNumber = req.getParameter("orderNumber");
        Customers customers = customerService.CustomerByNumber(customerNumber);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(sdf.format(new Date()));
            float sum_price = Float.parseFloat(commodityPrice) * Integer.parseInt(orderNumber);
            Order order = new Order(null,
                    commodityId,
                    customers.getCustomerName(),
                    customers.getCustomerNumber()
                    , customers.getCustomerAddress(),
                    "728479320@qq.com",
                    date,
                    sum_price);
            orderService.registOrder(order);
            List<Order> orderList = orderService.orderByNumber(customerNumber);
            OrderDetailed orderDetailed = new OrderDetailed(null, orderList.get(orderList.size() - 1).getOrderId(), commodityId
                    , Float.parseFloat(commodityPrice), Integer.parseInt(orderNumber), sum_price);
            orderDetailedService.registOrderDetailedService(orderDetailed);
            orderDetailedServlet.setOrderDetailed(req, resp);
            req.getRequestDispatcher("/pages/order/order_generation.jsp").forward(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        orderDetailedServlet.setOrderDetailed(req, resp);
        req.getRequestDispatcher("/pages/order/order_generation.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String orderId = req.getParameter("orderId");
        orderService.orderDelete(Integer.parseInt(orderId));
        orderDetailedServlet.setOrderDetailed(req, resp);
        req.getRequestDispatcher("/pages/order/order_generation.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if ("login".equals(action)) {
            login(req,resp);
        }else if ("regist".equals(action)){
            regist(req,resp);
        }else if("delete".equals(action)){
            delete(req,resp);
        }

    }
}
