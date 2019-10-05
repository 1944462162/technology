package com.imustacm.service;

import com.imustacm.domain.SpareParts;

import java.util.List;

public interface SparePartsService {


    List<SpareParts> getAllSpareParts() throws Exception;

    //增加原料库存
    int insertSpareParts(SpareParts spareParts) throws Exception;

    //根据ID删除原料库存
    int deleteSparePartsById(int index) throws Exception;

    //更新原料库存
    int updateSpareParts(SpareParts spareParts) throws Exception;

    //根据ID获取原料库存
    SpareParts getOneSpareParts(int index) throws Exception;


}
