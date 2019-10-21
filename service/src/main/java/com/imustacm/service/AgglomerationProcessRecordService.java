package com.imustacm.service;

import com.imustacm.domain.Po.AgglomerationProcessRecord;
import com.imustacm.domain.Vo.AgglomerationProcessRecordVo;

import java.util.List;

public interface AgglomerationProcessRecordService {

    List<AgglomerationProcessRecordVo> getAllAgglomerationProcessRecord() throws Exception;
    //增加原料库存
    int insertAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) throws Exception;

    //根据ID删除原料库存
    int deleteAgglomerationProcessRecordById(int index) throws Exception;

    //更新原料库存
    int updateAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) throws Exception;

    //根据ID获取原料库存
    AgglomerationProcessRecordVo getOneAgglomerationProcessRecord(int index) throws Exception;
}
