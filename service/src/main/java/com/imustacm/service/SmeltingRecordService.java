package com.imustacm.service;

import com.imustacm.domain.Vo.SmeltingRecordVo;

import java.util.List;

public interface SmeltingRecordService {
    List<SmeltingRecordVo> getAllSmeltingRecord();

    //增加原料库存
    int insertSmeltingRecord(SmeltingRecordVo smeltingRecordVo);

    //根据ID删除原料库存
    int deleteSmeltingRecordById(int index);

    //更新原料库存
    int updateSmeltingRecord(SmeltingRecordVo smeltingRecordVo);

    //根据ID获取原料库存
    SmeltingRecordVo getOneSmeltingRecord(int index);

    List<SmeltingRecordVo> getSmeltingRecordByCode(String index);

}
