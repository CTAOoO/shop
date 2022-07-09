package com.atctao.service;

import com.atctao.pojo.Commodity;
import com.atctao.pojo.Customers;

import java.util.List;

public interface CommodityService {
    /**
     * 通过id查找到Commodity
     * @param id
     * @return
     */
    public Commodity commodityById(String id);

    public List<Commodity> commodityALL();

    /**
     * 商品添加
     * @param commodity
     */
    public void commodityregist(Commodity commodity);
    /**
     * 检查商品编号是否可用
     * @param commodityId
     * @return 返回true表示已存在，返回false表示可用
     */
    public boolean existCommodityId(String commodityId);
}
