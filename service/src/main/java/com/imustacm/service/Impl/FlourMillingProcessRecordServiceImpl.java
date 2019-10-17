package com.imustacm.service.Impl;

import com.imustacm.dao.FlourMillingProcessRecordDao;
import com.imustacm.domain.Po.FlourMillingProcessRecord;
import com.imustacm.domain.Vo.FlourMillingProcessRecordVo;
import com.imustacm.service.FlourMillingProcessRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("flourMillingProcessRecordService")
public class FlourMillingProcessRecordServiceImpl implements FlourMillingProcessRecordService {


    @Autowired
    private FlourMillingProcessRecordDao flourMillingProcessRecordDao;

    @Override
    public List<FlourMillingProcessRecordVo> getAllFlourMillingProcessRecord() throws Exception {
        List<FlourMillingProcessRecordVo> result= new ArrayList<>();

        List<FlourMillingProcessRecord> flourMillingProcessRecords = flourMillingProcessRecordDao.selectEntryList(null);
        if(flourMillingProcessRecords!=null  && flourMillingProcessRecords.size()!=0  )
        {
            for (FlourMillingProcessRecord flourMillingProcessRecords1:flourMillingProcessRecords){
                FlourMillingProcessRecordVo flourMillingProcessRecordVo = new FlourMillingProcessRecordVo();
                BeanUtils.copyProperties(flourMillingProcessRecords1,flourMillingProcessRecordVo);
                result.add(flourMillingProcessRecordVo);
            }
        }
        return result;
    }

    @Override
    public int insertFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) throws Exception {

        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        BeanUtils.copyProperties(flourMillingProcessRecordVo,flourMillingProcessRecord);
        int isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
        if (isExist == 1){
            return 0;
        }
        flourMillingProcessRecordDao.insertEntry(flourMillingProcessRecord);
        return 1;
    }

    @Override
    public int deleteFlourMillingProcessRecordById(int index) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        Integer isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
        if(isExist == 1){
            flourMillingProcessRecordDao.deleteByKey(flourMillingProcessRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(flourMillingProcessRecordVo.getId());
        Integer isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        BeanUtils.copyProperties(flourMillingProcessRecordVo,flourMillingProcessRecord);
        // 如果存在就进行跟新
        flourMillingProcessRecordDao.updateByKey(flourMillingProcessRecord);
        return 1;
    }

    @Override
    public FlourMillingProcessRecordVo getOneFlourMillingProcessRecord(int index) throws Exception {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        FlourMillingProcessRecordVo flourMillingProcessRecordVo = new FlourMillingProcessRecordVo();
        List<FlourMillingProcessRecord> flourMillingProcessRecordList = flourMillingProcessRecordDao.selectEntryList(flourMillingProcessRecord);
        if (flourMillingProcessRecordList.size() != 0){
            flourMillingProcessRecord = flourMillingProcessRecordList.get(0);
            BeanUtils.copyProperties(flourMillingProcessRecord,flourMillingProcessRecordVo);
        }
        return flourMillingProcessRecordVo;
    }
}
