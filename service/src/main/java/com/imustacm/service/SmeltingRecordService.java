package com.imustacm.service;

import com.imustacm.domain.Po.SmeltingRecord;

import java.util.List;

public interface SmeltingRecordService {
    List<SmeltingRecord> getAllSmeltingRecord() throws Exception;

    //增加原料库存
    int insertSmeltingRecord(SmeltingRecord meltingRecord) throws Exception;

    //根据ID删除原料库存
    int deleteSmeltingRecordById(int index) throws Exception;

    //更新原料库存
    int updateSmeltingRecord(SmeltingRecord smeltingRecord) throws Exception;

    //根据ID获取原料库存
    SmeltingRecord getOneSmeltingRecord(int index) throws Exception;


}
