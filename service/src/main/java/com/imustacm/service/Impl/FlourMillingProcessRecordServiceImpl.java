package com.imustacm.service.Impl;

import com.imustacm.dao.FlourMillingProcessRecordDao;
import com.imustacm.domain.Po.FlourMillingProcessRecord;
import com.imustacm.service.FlourMillingProcessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("flourMillingProcessRecordService")
public class FlourMillingProcessRecordServiceImpl implements FlourMillingProcessRecordService {


    @Autowired
    private FlourMillingProcessRecordDao dao;

    @Override
    public List<FlourMillingProcessRecord> getAllFlourMillingProcessRecord() throws Exception {
        List<FlourMillingProcessRecord> result=null;

        List<FlourMillingProcessRecord> flourMillingProcessRecords = dao.selectEntryList(null);
        if(flourMillingProcessRecords!=null  && flourMillingProcessRecords.size()!=0  )
        {
            for (FlourMillingProcessRecord flourMillingProcessRecords1:flourMillingProcessRecords)
                result.add(flourMillingProcessRecords1);
        }

        return result;
    }

    @Override
    public int insertFlourMillingProcessRecord(FlourMillingProcessRecord flourMillingProcessRecord) throws Exception {
        int isExist = dao.selectEntryListCount(flourMillingProcessRecord);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(flourMillingProcessRecord);
        return 1;
    }

    @Override
    public int deleteFlourMillingProcessRecordById(int index) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        Integer isExist = dao.selectEntryListCount(flourMillingProcessRecord);
        if(isExist == 1){
            dao.deleteByKey(flourMillingProcessRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateFlourMillingProcessRecord(FlourMillingProcessRecord flourMillingProcessRecord) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord1 = new FlourMillingProcessRecord();
        flourMillingProcessRecord1.setId(flourMillingProcessRecord.getId());
        Integer isExist = dao.selectEntryListCount(flourMillingProcessRecord1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(flourMillingProcessRecord);
        return 1;
    }

    @Override
    public FlourMillingProcessRecord getOneFlourMillingProcessRecord(int index) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        List<FlourMillingProcessRecord> flourMillingProcessRecordList = dao.selectEntryList(flourMillingProcessRecord);
        if (flourMillingProcessRecordList.size() != 0){
            flourMillingProcessRecord = flourMillingProcessRecordList.get(0);
        }
        return flourMillingProcessRecord;
    }
}
