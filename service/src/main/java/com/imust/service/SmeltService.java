package com.imust.service;

import com.imust.domain.Vo.SmeltVo;

import java.util.List;

public interface SmeltService {


    List<SmeltVo> getAllSmelt();

    //增加原料库存
    int insertSmelt(SmeltVo smeltServiceImplVo);

    //根据ID删除原料库存
    int deleteSmeltById(int index);

    //更新原料库存
    int updateSmelt(SmeltVo smeltServiceImplVo);

    //根据ID获取原料库存
    SmeltVo getOneSmelt(int index);
}
