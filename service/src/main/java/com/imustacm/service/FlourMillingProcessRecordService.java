package com.imustacm.service;

import com.imustacm.domain.FlourMillingProcessRecord;

import java.util.List;

public interface FlourMillingProcessRecordService {

    List<FlourMillingProcessRecord> getAllFlourMillingProcessRecord() throws Exception;
    //增加原料库存
    int insertFlourMillingProcessRecord(FlourMillingProcessRecord flourMillingProcessRecord) throws Exception;

    //根据ID删除原料库存
    int deleteFlourMillingProcessRecordById(int index) throws Exception;

    //更新原料库存
    int updateFlourMillingProcessRecord(FlourMillingProcessRecord flourMillingProcessRecord) throws Exception;

    //根据ID获取原料库存
    FlourMillingProcessRecord getOneFlourMillingProcessRecord(int index) throws Exception;
}
