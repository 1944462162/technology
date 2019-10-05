package com.imustacm.service;

import com.imustacm.domain.AgglomerationProcessRecord;

import java.util.List;

public interface AgglomerationProcessRecordService {

    List<AgglomerationProcessRecord> getAllAgglomerationProcessRecord() throws Exception;
    //增加原料库存
    int insertAgglomerationProcessRecord(AgglomerationProcessRecord agglomerationProcessRecord) throws Exception;

    //根据ID删除原料库存
    int deleteAgglomerationProcessRecordById(int index) throws Exception;

    //更新原料库存
    int updateAgglomerationProcessRecord(AgglomerationProcessRecord agglomerationProcessRecord) throws Exception;

    //根据ID获取原料库存
    AgglomerationProcessRecord getOneAgglomerationProcessRecord(int index) throws Exception;
}
