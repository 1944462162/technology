package com.imustacm.service;

import com.imustacm.domain.Smelt;

import java.util.List;

public interface SmeltService {


    List<Smelt> getAllSmelt() throws Exception;

    //增加原料库存
    int insertSmelt(Smelt smeltServiceImpl) throws Exception;

    //根据ID删除原料库存
    int deleteSmeltById(int index) throws Exception;

    //更新原料库存
    int updateSmelt(Smelt smeltServiceImpl) throws Exception;

    //根据ID获取原料库存
    Smelt getOneSmelt(int index) throws Exception;
}
