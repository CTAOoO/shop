package com.atctao.web;

import com.atctao.pojo.Commodity;
import com.atctao.pojo.Norms;
import com.atctao.pojo.Sort;
import com.atctao.service.*;
import com.atctao.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CommodityServlet extends HttpServlet {
    private CommodityService commodityService = new CommodityServiceImpl();
    private SupplierService supplierService = new SupplierServiceImpl();
    private BrandService brandService = new BrandServiceImpl();
    private SortService sortService = new SortServiceImpl();
    private NormService normService = new NormServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commodityId = req.getParameter("commodityId");
        String brandName = req.getParameter("brandName");
        String vendorName = req.getParameter("VendorName");
        String sortId = req.getParameter("sortId");
        String commodityName = req.getParameter("commodityName");
        String metering = req.getParameter("metering");
        String marketValue = req.getParameter("marketValue");
        String salesPrice = req.getParameter("SalesPrice");
        String costPrice = req.getParameter("CostPrice");
        String commodityPhoto = req.getParameter("commodityPhoto");
        String commodityInformation = req.getParameter("commodityInformation");
        String stock = req.getParameter("stock");
        if (commodityService.existCommodityId(commodityId)){
            System.out.println("商品编号 " + commodityId + "已存在");
            req.setAttribute("msg", "商品编号已存在");
            req.setAttribute("commodityId",commodityId);
            req.getRequestDispatcher("/pages/commodity/commodity_regist.jsp").forward(req, resp);
        }else if (supplierService.existSupplierName(vendorName)) {
            System.out.println("供应商名 " + vendorName + "已存在");
            req.setAttribute("msg", "供应商名已存在");
            req.setAttribute("vendorName",vendorName);
            req.getRequestDispatcher("/pages/commodity/commodity_regist.jsp").forward(req, resp);
        } else if (brandService.existBrandName(brandName)) {
            System.out.println("商品品牌名称" + brandName + "已存在");
            req.setAttribute("msg", "商品品牌名称已存在");
            req.setAttribute("brandName", brandName);
            // 不可用 返回注册页面
            req.getRequestDispatcher("/pages/commodity/commodity_regist.jsp").forward(req, resp);
        } else if (sortService.existSortId(sortId)) {
            System.out.println("商品分类编号" + sortId + "已存在");
            req.setAttribute("msg", "商品分类编号已存在");
            req.setAttribute("sortId", sortId);
            req.getRequestDispatcher("/pages/sort/sort_regist.jsp").forward(req, resp);
        }else {
            Norms norms = normService.NormsByid(sortId);
            int kucun = Integer.valueOf(stock).intValue();
            Commodity commodity = new Commodity(commodityId,brandName,vendorName,sortId,commodityName
                    ,norms.getChengfen(),norms.getContent(),metering,Float.parseFloat(marketValue)
                    ,Float.parseFloat(salesPrice),Float.parseFloat(costPrice)
                    ,commodityPhoto,commodityInformation,kucun);
            commodityService.commodityregist(commodity);
            req.getRequestDispatcher("/pages/commodity/regist_success.jsp").forward(req,resp);
        }
    }

    public void setCommodity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Commodity> commodityList = commodityService.commodityALL();
        req.setAttribute("commodityList", commodityList);
    }
}
