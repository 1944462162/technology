package com.imustacm.service;

import com.imustacm.domain.Po.SmeltingRecord;
import com.imustacm.domain.Vo.SmeltingRecordVo;

import java.util.List;

public interface SmeltingRecordService {
    List<SmeltingRecordVo> getAllSmeltingRecord() throws Exception;

    //增加原料库存
    int insertSmeltingRecord(SmeltingRecordVo smeltingRecordVo) throws Exception;

    //根据ID删除原料库存
    int deleteSmeltingRecordById(int index) throws Exception;

    //更新原料库存
    int updateSmeltingRecord(SmeltingRecordVo smeltingRecordVo) throws Exception;

    //根据ID获取原料库存
    SmeltingRecordVo getOneSmeltingRecord(int index) throws Exception;


}
