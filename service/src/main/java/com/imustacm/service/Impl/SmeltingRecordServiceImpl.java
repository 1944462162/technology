package com.imustacm.service.Impl;


import com.imustacm.dao.SmeltingRecordDao;
import com.imustacm.domain.Po.SmeltingRecord;
import com.imustacm.domain.Vo.SmeltingRecordVo;
import com.imustacm.service.SmeltingRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("smeltingRecordService")
public class SmeltingRecordServiceImpl implements SmeltingRecordService {


    @Autowired
    SmeltingRecordDao smeltingRecordDao;


    @Override
    public List<SmeltingRecordVo> getAllSmeltingRecord() throws Exception {

        List<SmeltingRecordVo> result= new ArrayList<>();

        List<SmeltingRecord> spareParts = smeltingRecordDao.selectEntryList(null);
        if( spareParts!=null  && spareParts.size()!=0)
        {
            for (SmeltingRecord SmeltingRecord1:spareParts){
                SmeltingRecordVo smeltingRecordVo = new SmeltingRecordVo();
                BeanUtils.copyProperties(SmeltingRecord1,smeltingRecordVo);
                result.add(smeltingRecordVo);
            }
        }
        return result;
    }

    @Override
    public int insertSmeltingRecord(SmeltingRecordVo smeltingRecordVo) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        BeanUtils.copyProperties(smeltingRecordVo,smeltingRecord);
        int isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
        if (isExist == 1){
            return 0;
        }

        return smeltingRecordDao.insertEntry(smeltingRecord);
    }

    @Override
    public int deleteSmeltingRecordById(int index) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        Integer isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
        if(isExist == 1){

            return  smeltingRecordDao.deleteByKey(smeltingRecord);
        }
        return 0;
    }

    @Override
    public int updateSmeltingRecord(SmeltingRecordVo smeltingRecordVo) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(smeltingRecordVo.getId());
        Integer isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        BeanUtils.copyProperties(smeltingRecordVo,smeltingRecord);
        // 如果存在就进行跟新

        return smeltingRecordDao.updateByKey(smeltingRecord);
    }

    @Override
    public SmeltingRecordVo getOneSmeltingRecord(int index) throws Exception {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        SmeltingRecordVo smeltingRecordVo =  new SmeltingRecordVo();
        List<SmeltingRecord> sparePartsList = smeltingRecordDao.selectEntryList(smeltingRecord);
        if (sparePartsList.size() != 0){
            smeltingRecord = sparePartsList.get(0);
            BeanUtils.copyProperties(smeltingRecord,smeltingRecordVo);
        }
        return smeltingRecordVo;
    }
}
