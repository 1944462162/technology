package com.imust.service;

import com.imust.domain.Vo.SparePartsVo;

import java.util.List;

public interface SparePartsService {


    List<SparePartsVo> getAllSpareParts();

    //增加原料库存
    int insertSpareParts(SparePartsVo sparePartsVo);

    //根据ID删除原料库存
    int deleteSparePartsById(int index);

    //更新原料库存
    int updateSpareParts(SparePartsVo sparePartsVo);

    //根据ID获取原料库存
    SparePartsVo getOneSpareParts(int index);

    //根据牌号获取原料库存
    SparePartsVo getSparePartsByCode(String code);


}
