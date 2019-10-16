package com.imustacm.service;

import com.imustacm.domain.Po.AgglomerationProcess;

import java.util.List;

public interface AgglomerationProcessService {

    List<AgglomerationProcess> getAllAgglomerationProcess() throws Exception;
    //增加原料库存
    int insertAgglomerationProcess(AgglomerationProcess agglomerationProcess) throws Exception;

    //根据ID删除原料库存
    int deleteAgglomerationProcessById(int index) throws Exception;

    //更新原料库存
    int updateAgglomerationProcess(AgglomerationProcess agglomerationProcess) throws Exception;

    //根据ID获取原料库存
    AgglomerationProcess getOneAgglomerationProcess(int index) throws Exception;
}
