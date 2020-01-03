package com.imust.service;

import com.imust.domain.Vo.PressureRecordVo;

import java.util.List;

public interface PressureRecordService {


    List<PressureRecordVo> getAllPressureRecord();
    //增加原料库存
    int insertPressureRecord(PressureRecordVo pressureRecordVo);

    //根据ID删除原料库存
    int deletePressureRecordById(int index);

    //更新原料库存
    int updatePressureRecord(PressureRecordVo pressureRecordVo);

    //根据ID获取原料库存
    PressureRecordVo getOnePressureRecord(int index);

    //根据编码获取库存
    List<PressureRecordVo> getPressureRecordByCode(String number);

    int getNewInsertPressureRecord();
}
