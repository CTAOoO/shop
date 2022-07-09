package com.atctao.service;

import com.atctao.pojo.Brand;

public interface BrandService {
    /**
     * 注册商品品牌
     * @param brand
     */
    public void registBrand(Brand brand);

    /**
     * 检查商品品牌名称是否可用
     * @param name
     * @return 返回true表示已存在，返回false表示可用
     */
    public boolean existBrandName(String name);
}
