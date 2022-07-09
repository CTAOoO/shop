package com.atctao.service;

import com.atctao.pojo.Norms;

public interface NormService {
    /**
     * 商品规格注册
     * @param norms
     */
    public void registNorm(Norms norms);

    /**
     * 商品分类编号查找规格
     * @param sortId
     * @return
     */
    public Norms NormsByid(String sortId);
}
