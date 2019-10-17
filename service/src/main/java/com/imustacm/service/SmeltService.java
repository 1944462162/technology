package com.imustacm.service;

import com.imustacm.domain.Po.Smelt;
import com.imustacm.domain.Vo.SmeltVo;

import java.util.List;

public interface SmeltService {


    List<SmeltVo> getAllSmelt() throws Exception;

    //增加原料库存
    int insertSmelt(SmeltVo smeltServiceImplVo) throws Exception;

    //根据ID删除原料库存
    int deleteSmeltById(int index) throws Exception;

    //更新原料库存
    int updateSmelt(SmeltVo smeltServiceImplVo) throws Exception;

    //根据ID获取原料库存
    SmeltVo getOneSmelt(int index) throws Exception;
}
