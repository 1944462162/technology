package com.imustacm.service;

import com.imustacm.domain.Vo.AgglomerationProcessRecordVo;

import java.util.List;

public interface AgglomerationProcessRecordService {

    List<AgglomerationProcessRecordVo> getAllAgglomerationProcessRecord();
    //增加原料库存
    int insertAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo);

    //根据ID删除原料库存
    int deleteAgglomerationProcessRecordById(int index);

    //更新原料库存
    int updateAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo);

    //根据ID获取原料库存
    AgglomerationProcessRecordVo getOneAgglomerationProcessRecord(int index);

    int getNewInsertagglomerationProcessRecords();
}
