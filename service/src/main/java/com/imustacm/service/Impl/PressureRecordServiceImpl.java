package com.imustacm.service.Impl;


import com.imustacm.dao.PressureRecordDao;
import com.imustacm.domain.Po.PressureRecord;
import com.imustacm.domain.Vo.PressureRecordVo;
import com.imustacm.service.PressureRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pressureRecordService")
public class PressureRecordServiceImpl implements PressureRecordService {


    @Autowired
    private PressureRecordDao pressureRecordDao;


    @Override
    public List<PressureRecordVo> getAllPressureRecord() throws Exception {
        List<PressureRecordVo> result= new ArrayList<>();
        List<PressureRecord> pressureRecords = pressureRecordDao.selectEntryList(null);
        if(pressureRecords!=null  && pressureRecords.size()!=0)
        {
            for (PressureRecord pressureRecords1:pressureRecords){
                PressureRecordVo pressureRecordVo = new PressureRecordVo();
                BeanUtils.copyProperties(pressureRecords1,pressureRecordVo);
                result.add(pressureRecordVo);
            }
        }
        return result;
    }

    @Override
    public int insertPressureRecord(PressureRecordVo pressureRecordVo) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        BeanUtils.copyProperties(pressureRecordVo,pressureRecord);
        int isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
        if (isExist == 1){
            return 0;
        }
        pressureRecordDao.insertEntry(pressureRecord);
        return 1;
    }

    @Override
    public int deletePressureRecordById(int index) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(index);
        Integer isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
        if(isExist == 1){
            pressureRecordDao.deleteByKey(pressureRecord);
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePressureRecord(PressureRecordVo pressureRecordVo) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(pressureRecordVo.getId());
        Integer isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        BeanUtils.copyProperties(pressureRecordVo,pressureRecord);
        // 如果存在就进行跟新
        pressureRecordDao.updateByKey(pressureRecord);
        return 1;
    }

    @Override
    public PressureRecordVo getOnePressureRecord(int index) throws Exception {
        PressureRecord pressureRecord = new PressureRecord();
        PressureRecordVo pressureRecordVo = new PressureRecordVo();
        pressureRecord.setId(index);
        List<PressureRecord> pressureRecordList = pressureRecordDao.selectEntryList(pressureRecord);
        if (pressureRecordList.size() != 0){
            pressureRecord = pressureRecordList.get(0);
            BeanUtils.copyProperties(pressureRecord,pressureRecordVo);
        }
        return pressureRecordVo;
    }
}
