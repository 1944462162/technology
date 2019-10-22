package com.imustacm.service;

import com.imustacm.domain.Vo.AgglomerationProcessVo;

import java.util.List;

public interface AgglomerationProcessService {

    List<AgglomerationProcessVo> getAllAgglomerationProcess() throws Exception;

    int insertAgglomerationProcess(AgglomerationProcessVo agglomerationProcessVo) throws Exception;


    int deleteAgglomerationProcessById(int index) throws Exception;


    int updateAgglomerationProcess(AgglomerationProcessVo agglomerationProcessVo) throws Exception;


    AgglomerationProcessVo getOneAgglomerationProcess(int index) throws Exception;

    int insertRelationOfAgglomerationAndProcess(int RecordId, int... processGroupId) throws Exception;

    int deleteOneRelation(int RecordId, int ProcessId) throws Exception;

    int  updateRelationOfAgglomerationAndProcess(int RecordId, int... processGroupId) throws Exception;
}
