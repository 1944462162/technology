package com.imustacm.service.Impl;

import com.imustacm.dao.AgglomerationProcessDao;
import com.imustacm.dao.AgglomerationProcessRecordDao;
import com.imustacm.domain.Po.AgglomerationProcess;
import com.imustacm.domain.Po.AgglomerationProcessRecord;
import com.imustacm.domain.Vo.AgglomerationProcessRecordVo;
import com.imustacm.service.AgglomerationProcessRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("agglomerationProcessRecordService")
public class AgglomerationProcessRecordServiceImpl implements AgglomerationProcessRecordService {


    @Autowired
    private AgglomerationProcessRecordDao agglomerationProcessRecordDao;


    @Override
    public List<AgglomerationProcessRecordVo> getAllAgglomerationProcessRecord() throws Exception {
        List<AgglomerationProcessRecordVo> result= new ArrayList<>();

        List<AgglomerationProcessRecord> agglomerationProcessRecords = agglomerationProcessRecordDao.selectEntryList(null);
        if(agglomerationProcessRecords!=null && agglomerationProcessRecords.size()!=0)
        {
            for (AgglomerationProcessRecord agglomerationProcessRecord:agglomerationProcessRecords)
            {
                AgglomerationProcessRecordVo agglomerationProcessRecordVo = new AgglomerationProcessRecordVo();
                BeanUtils.copyProperties(agglomerationProcessRecord,agglomerationProcessRecordVo);
                result.add(agglomerationProcessRecordVo);
            }
        }

        return result;
    }

    @Override
    public int insertAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) throws Exception {
       AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
       BeanUtils.copyProperties(agglomerationProcessRecordVo,agglomerationProcessRecord);
        int isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
        if (isExist == 1){
            return 0;
        }
        return agglomerationProcessRecordDao.insertEntry(agglomerationProcessRecord);
    }

    @Override
    public int deleteAgglomerationProcessRecordById(int index) throws Exception {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId(index);
        Integer isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
        if(isExist == 1){
            return agglomerationProcessRecordDao.deleteByKey(agglomerationProcessRecord);
        }
        return 0;
    }

    @Override
    public int updateAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) throws Exception {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId( agglomerationProcessRecordVo.getId());
        Integer isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        BeanUtils.copyProperties(agglomerationProcessRecordVo,agglomerationProcessRecord);
        return agglomerationProcessRecordDao.updateByKey(agglomerationProcessRecord);
    }

    @Override
    public AgglomerationProcessRecordVo getOneAgglomerationProcessRecord(int index) throws Exception {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        AgglomerationProcessRecordVo agglomerationProcessRecordVo = new AgglomerationProcessRecordVo();
        agglomerationProcessRecord.setId(index);
        List<AgglomerationProcessRecord> blankSizeList = agglomerationProcessRecordDao.selectEntryList(agglomerationProcessRecord);
        if (blankSizeList.size() != 0){
            agglomerationProcessRecord = blankSizeList.get(0);
            BeanUtils.copyProperties(agglomerationProcessRecord,agglomerationProcessRecordVo);
        }
        return agglomerationProcessRecordVo;
    }



    @Override
    public int getNewInsertagglomerationProcessRecords() {
        int k = 0;
        try {
            List<AgglomerationProcessRecord> agglomerationProcessRecords = agglomerationProcessRecordDao.selectEntryList(null);
            for (AgglomerationProcessRecord agglomerationProcessRecord : agglomerationProcessRecords) {
                k = agglomerationProcessRecord.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

}
