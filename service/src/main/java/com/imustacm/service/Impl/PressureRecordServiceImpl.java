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
    public List<PressureRecordVo> getAllPressureRecord() {
        List<PressureRecordVo> result= new ArrayList<>();
        List<PressureRecord> pressureRecords = null;
        try {
            pressureRecords = pressureRecordDao.selectEntryList(null);
            if(pressureRecords!=null  && pressureRecords.size()!=0)
            {
                for (PressureRecord pressureRecords1:pressureRecords){
                    PressureRecordVo pressureRecordVo = new PressureRecordVo();
                    BeanUtils.copyProperties(pressureRecords1,pressureRecordVo);
                    result.add(pressureRecordVo);
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取所有压型记录信息出现异常");
        }

    }

    @Override
    public int insertPressureRecord(PressureRecordVo pressureRecordVo) {
        PressureRecord pressureRecord = new PressureRecord();
        BeanUtils.copyProperties(pressureRecordVo,pressureRecord);
        int isExist = 0;
        try {
            isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
            if (isExist == 1){
                return 0;
            }

            return  pressureRecordDao.insertEntry(pressureRecord);
        } catch (Exception e) {
            throw new RuntimeException("插入压型信息出现异常");
        }

    }

    @Override
    public int deletePressureRecordById(int index) {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(index);
        Integer isExist = null;
        try {
            isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
            if(isExist == 1){
                return  pressureRecordDao.deleteByKey(pressureRecord);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("删除压型记录表信息失败");
        }

    }

    @Override
    public int updatePressureRecord(PressureRecordVo pressureRecordVo) {
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setId(pressureRecordVo.getId());
        Integer isExist = null;
        try {
            isExist = pressureRecordDao.selectEntryListCount(pressureRecord);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            BeanUtils.copyProperties(pressureRecordVo,pressureRecord);
            // 如果存在就进行跟新
            return pressureRecordDao.updateByKey(pressureRecord);
        } catch (Exception e) {
            throw new RuntimeException("跟新压型记录表信息失败");
        }

    }


    //根据ID获取信息
    @Override
    public PressureRecordVo getOnePressureRecord(int index) {
        PressureRecord pressureRecord = new PressureRecord();
        PressureRecordVo pressureRecordVo = new PressureRecordVo();
        pressureRecord.setId(index);
        List<PressureRecord> pressureRecordList = null;
        try {
            pressureRecordList = pressureRecordDao.selectEntryList(pressureRecord);
            if (pressureRecordList.size() != 0){
                pressureRecord = pressureRecordList.get(0);
                BeanUtils.copyProperties(pressureRecord,pressureRecordVo);
            }
            return pressureRecordVo;
        } catch (Exception e) {
            throw new RuntimeException("获取单个信息失败");
        }

    }

    //根据编码获取信息
    public List<PressureRecordVo> getPressureRecordByCode(String number) {
        List<PressureRecordVo> result = new ArrayList<>();
        PressureRecord pressureRecord = new PressureRecord();
        pressureRecord.setSerial(number);
        List<PressureRecord> pressureRecords = null;
        try {
            pressureRecords = pressureRecordDao.selectEntryList(pressureRecord);
            if(pressureRecords!=null  && pressureRecords.size()!=0)
            {
                for (PressureRecord pressureRecords1:pressureRecords){
                    PressureRecordVo pressureRecordVo = new PressureRecordVo();
                    BeanUtils.copyProperties(pressureRecords1,pressureRecordVo);
                    result.add(pressureRecordVo);
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("根据编码获取信息出现异常");
        }

    }

    @Override
    public int getNewInsertPressureRecord() {
        int k = 0;
        try {
            List<PressureRecord> pressureRecords = pressureRecordDao.selectEntryList(null);
            for (PressureRecord pressureRecord : pressureRecords) {
                k = pressureRecord.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

}
