package com.imust.service;

import com.imust.domain.Vo.FlourMillingProcessRecordVo;

import java.util.List;

public interface FlourMillingProcessRecordService {

    List<FlourMillingProcessRecordVo> getAllFlourMillingProcessRecord();
    //增加原料库存
    int insertFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo);

    //根据ID删除原料库存
    int deleteFlourMillingProcessRecordById(int index);

    //更新原料库存
    int updateFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo);

    //根据ID获取原料库存
    FlourMillingProcessRecordVo getOneFlourMillingProcessRecord(int index);
}
