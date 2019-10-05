package com.imustacm.service.Impl;

import com.imustacm.dao.AgglomerationProcessRecordDao;
import com.imustacm.domain.AgglomerationProcessRecord;
import com.imustacm.service.AgglomerationProcessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("agglomerationProcessRecordService")
public class AgglomerationProcessRecordServiceImpl implements AgglomerationProcessRecordService {


    @Autowired
    private AgglomerationProcessRecordDao dao;


    @Override
    public List<AgglomerationProcessRecord> getAllAgglomerationProcessRecord() throws Exception {
        List<AgglomerationProcessRecord> result=null;

        List<AgglomerationProcessRecord> agglomerationProcessRecords = dao.selectEntryList(null);
        if(agglomerationProcessRecords!=null && agglomerationProcessRecords.size()!=0  )
        {
            for (AgglomerationProcessRecord agglomerationProcessRecord1:agglomerationProcessRecords)
                result.add(agglomerationProcessRecord1);
        }

        return result;
    }

    @Override
    public int insertAgglomerationProcessRecord(AgglomerationProcessRecord agglomerationProcessRecord) throws Exception {
        int isExist = dao.selectEntryListCount(agglomerationProcessRecord);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(agglomerationProcessRecord);
        return 1;
    }

    @Override
    public int deleteAgglomerationProcessRecordById(int index) throws Exception {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId(index);
        Integer isExist = dao.selectEntryListCount(agglomerationProcessRecord);
        if(isExist == 1){
            dao.deleteByKey(agglomerationProcessRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateAgglomerationProcessRecord(AgglomerationProcessRecord agglomerationProcessRecord) throws Exception {
        AgglomerationProcessRecord blankSize1 = new AgglomerationProcessRecord();
        blankSize1.setId( agglomerationProcessRecord.getId());
        Integer isExist = dao.selectEntryListCount(blankSize1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(agglomerationProcessRecord);
        return 1;
    }

    @Override
    public AgglomerationProcessRecord getOneAgglomerationProcessRecord(int index) throws Exception {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId(index);
        List<AgglomerationProcessRecord> blankSizeList = dao.selectEntryList(agglomerationProcessRecord);
        if (blankSizeList.size() != 0){
            agglomerationProcessRecord = blankSizeList.get(0);
        }
        return agglomerationProcessRecord;
    }
}
