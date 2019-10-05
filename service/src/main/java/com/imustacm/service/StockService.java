package com.imustacm.service;

import com.imustacm.domain.Stock;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 18:48
 * Content:
 */
public interface StockService {

    //获取所有的原料库存
    List<Stock> getAllStoch() throws Exception;

    //增加原料库存
    int insertStoch(Stock stock) throws Exception;

    //根据ID删除原料库存
    int deleteStochById(int index) throws Exception;

    //更新原料库存
    int updateStock(Stock stock) throws Exception;

    //根据ID获取原料库存
    Stock getOneStock(int index) throws Exception;
}
