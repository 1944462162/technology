package com.imustacm.service.Impl;


import com.imustacm.dao.PressureRecordDao;
import com.imustacm.domain.PressureRecord;
import com.imustacm.service.PressureRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pressureRecordService")
public class PressureRecordServiceImpl implements PressureRecordService {


    @Autowired
    private PressureRecordDao dao;


    @Override
    public List<PressureRecord> getAllPressureRecord() throws Exception {
        List<PressureRecord> result=null;

        List<PressureRecord> pressureRecords = dao.selectEntryList(null);
        if(pressureRecords!=null  && pressureRecords.size()!=0  )
        {
            for (PressureRecord pressureRecords1:pressureRecords)
                result.add(pressureRecords1);
        }

        return result;
    }

    @Override
    public int insertPressureRecord(PressureRecord pressureRecord) throws Exception {
        int isExist = dao.selectEntryListCount(pressureRecord);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(pressureRecord);
        return 1;
    }

    @Override
    public int deletePressureRecordById(int index) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(index);
        Integer isExist = dao.selectEntryListCount(pressureRecord);
        if(isExist == 1){
            dao.deleteByKey(pressureRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePressureRecord(PressureRecord pressureRecord) throws Exception {
        PressureRecord pressureRecord1 = new PressureRecord();
        pressureRecord1.setId(pressureRecord.getId());
        Integer isExist = dao.selectEntryListCount(pressureRecord1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(pressureRecord);
        return 1;
    }

    @Override
    public PressureRecord getOnePressureRecord(int index) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(index);
        List<PressureRecord> pressureRecordList = dao.selectEntryList(pressureRecord);
        if (pressureRecordList.size() != 0){
            pressureRecord = pressureRecordList.get(0);
        }
        return pressureRecord;
    }
}
