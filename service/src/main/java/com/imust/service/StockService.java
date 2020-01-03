package com.imust.service;

import com.imust.domain.Vo.StockVo;

import java.util.List;


public interface StockService {

    //获取所有的原料库存
    List<StockVo> getAllStock();

    //增加原料库存
    int insertStock(StockVo stockVo);

    //根据ID删除原料库存
    int deleteStockById(int index);

    //更新原料库存
    int updateStock(StockVo stockVo);

    //根据ID获取原料库存
    StockVo getOneStock(int index);
}
