package com.imustacm.service.Impl;

import com.imustacm.dao.SmeltingRecordDao;
import com.imustacm.domain.Po.SmeltingRecord;
import com.imustacm.service.SmeltingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("smeltingRecordService")
public class SmeltingRecordServiceImpl implements SmeltingRecordService {


    @Autowired
    SmeltingRecordDao dao;


    @Override
    public List<SmeltingRecord> getAllSmeltingRecord() throws Exception {

        List<SmeltingRecord> result=null;

        List<SmeltingRecord> spareParts = dao.selectEntryList(null);
        if( spareParts!=null  && spareParts.size()!=0  )
        {
            for (SmeltingRecord SmeltingRecord1:spareParts)
                result.add(SmeltingRecord1);
        }

        return result;
    }

    @Override
    public int insertSmeltingRecord(SmeltingRecord smeltingRecord) throws Exception {
        int isExist = dao.selectEntryListCount(smeltingRecord);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(smeltingRecord);
        return 1;
    }

    @Override
    public int deleteSmeltingRecordById(int index) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        Integer isExist = dao.selectEntryListCount(smeltingRecord);
        if(isExist == 1){
            dao.deleteByKey(smeltingRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateSmeltingRecord(SmeltingRecord smeltingRecord) throws Exception {
        SmeltingRecord smeltingRecord1 = new SmeltingRecord();
        smeltingRecord1.setId(smeltingRecord.getId());
        Integer isExist = dao.selectEntryListCount(smeltingRecord1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(smeltingRecord);
        return 1;
    }

    @Override
    public SmeltingRecord getOneSmeltingRecord(int index) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        List<SmeltingRecord> sparePartsList = dao.selectEntryList(smeltingRecord);
        if (sparePartsList.size() != 0){
            smeltingRecord = sparePartsList.get(0);
        }
        return smeltingRecord;
    }
}
