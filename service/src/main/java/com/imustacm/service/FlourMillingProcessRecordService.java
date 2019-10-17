package com.imustacm.service;

import com.imustacm.domain.Po.FlourMillingProcessRecord;
import com.imustacm.domain.Vo.FlourMillingProcessRecordVo;

import java.util.List;

public interface FlourMillingProcessRecordService {

    List<FlourMillingProcessRecordVo> getAllFlourMillingProcessRecord() throws Exception;
    //增加原料库存
    int insertFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) throws Exception;

    //根据ID删除原料库存
    int deleteFlourMillingProcessRecordById(int index) throws Exception;

    //更新原料库存
    int updateFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) throws Exception;

    //根据ID获取原料库存
    FlourMillingProcessRecordVo getOneFlourMillingProcessRecord(int index) throws Exception;
}
