package com.imustacm.service;

import com.imustacm.domain.Po.Stock;
import com.imustacm.domain.Vo.StockVo;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 18:48
 * Content:
 */
public interface StockService {

    //获取所有的原料库存
    List<StockVo> getAllStock() throws Exception;

    //增加原料库存
    int insertStock(StockVo stockVo) throws Exception;

    //根据ID删除原料库存
    int deleteStockById(int index) throws Exception;

    //更新原料库存
    int updateStock(StockVo stockVo) throws Exception;

    //根据ID获取原料库存
    StockVo getOneStock(int index) throws Exception;
}
