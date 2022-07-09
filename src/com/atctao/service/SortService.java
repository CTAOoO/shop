package com.atctao.service;

import com.atctao.pojo.Sort;

public interface SortService {
    /**
     * 注册商品分类
     * @param sort
     */
    public void registSort(Sort sort);

    /**
     * 检查商品分类编号是否可用
     * @param id
     * @return 返回true表示已存在，返回false表示可用
     */
    public boolean existSortId(String id);
    /**
     * 检查商品分类名称是否重复
     * @param name
     * @return
     */
    public boolean existSortName(String name);
}
