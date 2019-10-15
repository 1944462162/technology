package com.imustacm.service.Impl;

import com.imustacm.dao.AgglomerationProcessDao;
import com.imustacm.domain.AgglomerationProcess;
import com.imustacm.service.AgglomerationProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("agglomerationProcessService")
public class AgglomerationProcessServiceImpl implements AgglomerationProcessService {

    @Autowired
    private AgglomerationProcessDao dao;
    @Override
    public List<AgglomerationProcess> getAllAgglomerationProcess() throws Exception {
        List<AgglomerationProcess> result= new ArrayList<>();

        List<AgglomerationProcess> agglomerationProcesses = dao.selectEntryList(null);
        if(agglomerationProcesses!=null && agglomerationProcesses.size()!=0  )
        {
            for (AgglomerationProcess agglomerationProcess : agglomerationProcesses) {
                result.add(agglomerationProcess);
            }
        }
        return result;
    }

    @Override
    public int insertAgglomerationProcess(AgglomerationProcess agglomerationProcess) throws Exception {
        int isExist = dao.selectEntryListCount(agglomerationProcess);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(agglomerationProcess);
        return 1;
    }

    @Override
    public int deleteAgglomerationProcessById(int index) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        agglomerationProcess.setId(index);
        Integer isExist = dao.selectEntryListCount(agglomerationProcess);
        if(isExist == 1){
            dao.deleteByKey(agglomerationProcess);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateAgglomerationProcess(AgglomerationProcess agglomerationProcess) throws Exception {
        AgglomerationProcess agglomerationProcess1 = new AgglomerationProcess();
        agglomerationProcess1.setId( agglomerationProcess.getId());
        Integer isExist = dao.selectEntryListCount(agglomerationProcess1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(agglomerationProcess);
        return 1;
    }

    @Override
    public AgglomerationProcess getOneAgglomerationProcess(int index) throws Exception {
        AgglomerationProcess agglomerationProcess = new AgglomerationProcess();
        agglomerationProcess.setId(index);
        List<AgglomerationProcess> blankSizeList = dao.selectEntryList(agglomerationProcess);
        if (blankSizeList.size() != 0){
            agglomerationProcess = blankSizeList.get(0);
        }
        return agglomerationProcess;
    }
}
