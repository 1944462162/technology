package com.imustacm.service;

import com.imustacm.domain.Po.PressureRecord;

import java.util.List;

public interface PressureRecordService {


    List<PressureRecord> getAllPressureRecord() throws Exception;
    //增加原料库存
    int insertPressureRecord(PressureRecord pressureRecord) throws Exception;

    //根据ID删除原料库存
    int deletePressureRecordById(int index) throws Exception;

    //更新原料库存
    int updatePressureRecord(PressureRecord pressureRecord) throws Exception;

    //根据ID获取原料库存
    PressureRecord getOnePressureRecord(int index) throws Exception;
}
