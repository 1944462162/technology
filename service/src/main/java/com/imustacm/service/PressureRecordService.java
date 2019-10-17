package com.imustacm.service;

import com.imustacm.domain.Po.PressureRecord;
import com.imustacm.domain.Vo.PressureRecordVo;

import java.util.List;

public interface PressureRecordService {


    List<PressureRecordVo> getAllPressureRecord() throws Exception;
    //增加原料库存
    int insertPressureRecord(PressureRecordVo pressureRecordVo) throws Exception;

    //根据ID删除原料库存
    int deletePressureRecordById(int index) throws Exception;

    //更新原料库存
    int updatePressureRecord(PressureRecordVo pressureRecordVo) throws Exception;

    //根据ID获取原料库存
    PressureRecordVo getOnePressureRecord(int index) throws Exception;
}
