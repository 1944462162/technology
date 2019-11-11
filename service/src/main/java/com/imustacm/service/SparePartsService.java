package com.imustacm.service;

import com.imustacm.domain.Po.SpareParts;
import com.imustacm.domain.Vo.SparePartsVo;

import java.util.List;

public interface SparePartsService {


    List<SparePartsVo> getAllSpareParts() throws Exception;

    //增加原料库存
    int insertSpareParts(SparePartsVo sparePartsVo) throws Exception;

    //根据ID删除原料库存
    int deleteSparePartsById(int index) throws Exception;

    //更新原料库存
    int updateSpareParts(SparePartsVo sparePartsVo) throws Exception;

    //根据ID获取原料库存
    SparePartsVo getOneSpareParts(int index) throws Exception;

    //根据牌号获取原料库存
    List<SparePartsVo> getSparePartsByCode(Integer number) throws Exception;


}
