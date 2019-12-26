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
    public List<SmeltingRecordVo> getAllSmeltingRecord() {

        List<SmeltingRecordVo> result= new ArrayList<>();

        List<SmeltingRecord> spareParts = null;
        try {
            spareParts = smeltingRecordDao.selectEntryList(null);
            if( spareParts!=null  && spareParts.size()!=0)
            {
                for (SmeltingRecord SmeltingRecord1:spareParts){
                    SmeltingRecordVo smeltingRecordVo = new SmeltingRecordVo();
                    BeanUtils.copyProperties(SmeltingRecord1,smeltingRecordVo);
                    result.add(smeltingRecordVo);
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取所有冶炼操作记录表信息失败");
        }

    }

    @Override
    public int insertSmeltingRecord(SmeltingRecordVo smeltingRecordVo) {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        BeanUtils.copyProperties(smeltingRecordVo,smeltingRecord);

        try {
            Integer isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
            if (isExist == 1){
                return 0;
            }

            return smeltingRecordDao.insertEntry(smeltingRecord);

        } catch (Exception e) {
            throw new RuntimeException("插入冶炼操作记录表信息出现异常");
        }

    }

    @Override
    public int deleteSmeltingRecordById(int index) {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        Integer isExist = null;
        try {
            isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
            if(isExist == 1){

                return  smeltingRecordDao.deleteByKey(smeltingRecord);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("通过Id删除冶炼操作记录表信息出现异常");
        }
    }

    @Override
    public int updateSmeltingRecord(SmeltingRecordVo smeltingRecordVo) {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(smeltingRecordVo.getId());
        Integer isExist = null;
        try {
            isExist = smeltingRecordDao.selectEntryListCount(smeltingRecord);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            BeanUtils.copyProperties(smeltingRecordVo,smeltingRecord);
            // 如果存在就进行跟新

            return smeltingRecordDao.updateByKey(smeltingRecord);
        } catch (Exception e) {
            throw new RuntimeException("跟新冶炼操作记录表信息出现异常");
        }

    }

    @Override
    public SmeltingRecordVo getOneSmeltingRecord(int index) {
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setId(index);
        SmeltingRecordVo smeltingRecordVo =  new SmeltingRecordVo();
        List<SmeltingRecord> sparePartsList = null;
        try {
            sparePartsList = smeltingRecordDao.selectEntryList(smeltingRecord);
            if (sparePartsList.size() != 0){
                smeltingRecord = sparePartsList.get(0);
                BeanUtils.copyProperties(smeltingRecord,smeltingRecordVo);
            }
            return smeltingRecordVo;
        } catch (Exception e) {
            throw new RuntimeException("获取一个冶炼操作记录信息");
        }

    }

    // 根据编号进行查找
    public List<SmeltingRecordVo> getSmeltingRecordByCode(String index) {
        List<SmeltingRecordVo> list = new ArrayList<>();
        SmeltingRecord smeltingRecord = new SmeltingRecord();
        smeltingRecord.setSerial(index);
        List<SmeltingRecord> smeltingRecords = null;
        try {
            smeltingRecords = smeltingRecordDao.selectEntryList(smeltingRecord);
            if (smeltingRecords != null && smeltingRecords.size() != 0){
                for (SmeltingRecord record : smeltingRecords) {
                    SmeltingRecordVo smeltingRecordVo = new SmeltingRecordVo();
                    BeanUtils.copyProperties(record,smeltingRecordVo);
                    list.add(smeltingRecordVo);
                }
            }
            return list;
        } catch (Exception e) {
           throw new RuntimeException("根据编号查找信息失败");
        }

    }
}
