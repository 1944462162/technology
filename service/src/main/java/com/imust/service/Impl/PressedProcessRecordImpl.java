package com.imust.service.Impl;

import com.imust.dao.PressedProcessRecordDao;
import com.imust.domain.Po.PressedProcessRecord;
import com.imust.domain.Vo.PressedProcessRecordVo;
import com.imust.service.PressedProcessRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/1/2 10:18
 * Content:
 */
@Service("pressedProcessRecord")
public class PressedProcessRecordImpl implements PressedProcessRecordService {

    @Autowired
    private PressedProcessRecordDao pressedProcessRecordDao;

    @Override
    public List<PressedProcessRecordVo> getAllPressedProcessRecord() {

        List<PressedProcessRecordVo> pressedProcessRecordVos = new ArrayList<>();
        try {
            List<PressedProcessRecord> pressedProcessRecords = pressedProcessRecordDao.selectEntryList(null);
            if (pressedProcessRecords != null && pressedProcessRecords.size() != 0){
                for (PressedProcessRecord pressedProcessRecord : pressedProcessRecords) {
                    PressedProcessRecordVo pressedProcessRecordVo = new PressedProcessRecordVo();
                    BeanUtils.copyProperties(pressedProcessRecord,pressedProcessRecordVo);
                    pressedProcessRecordVos.add(pressedProcessRecordVo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pressedProcessRecordVos;
    }

    @Override
    public int insertPressedProcessRecord(PressedProcessRecordVo pressedProcessRecordVo) {

        PressedProcessRecord pressedProcessRecord = new PressedProcessRecord();
        BeanUtils.copyProperties(pressedProcessRecordVo,pressedProcessRecord);
        try {
            Integer isExist = pressedProcessRecordDao.selectEntryListCount(pressedProcessRecord);

            if (isExist == 0){

                return pressedProcessRecordDao.insertEntry(pressedProcessRecord);
            }
            else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("插入压型工艺记录失败");
        }
    }

    @Override
    public int deletePressedProcessRecordById(int index) {

        PressedProcessRecord pressedProcessRecord = new PressedProcessRecord();
        pressedProcessRecord.setId(index);
        try {
            Integer isExist = pressedProcessRecordDao.selectEntryListCount(pressedProcessRecord);
            if (isExist == 1){
               return pressedProcessRecordDao.deleteByKey(pressedProcessRecord);
            }
            else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("删除压型记录失败");
        }
    }

    @Override
    public int updatePressedProcessRecord(PressedProcessRecordVo pressedProcessRecordVo) {
        PressedProcessRecord pressedProcessRecord = new PressedProcessRecord();
        pressedProcessRecord.setId(pressedProcessRecordVo.getId());
        try {
            Integer isExist = pressedProcessRecordDao.selectEntryListCount(pressedProcessRecord);
            if (isExist == 1){
                BeanUtils.copyProperties(pressedProcessRecordVo,pressedProcessRecord);
                return pressedProcessRecordDao.updateByKey(pressedProcessRecord);
            }
            else{
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("更新压型记录信息出现异常");
        }
    }

    @Override
    public PressedProcessRecordVo getOnePressedProcessRecordBySerial(String serial) {

        PressedProcessRecordVo pressedProcessRecordVo = new PressedProcessRecordVo();
        PressedProcessRecord pressedProcessRecord = new PressedProcessRecord();
        pressedProcessRecord.setSerial(serial);
        try {
            List<PressedProcessRecord> pressedProcessRecords = pressedProcessRecordDao.selectEntryList(pressedProcessRecord);
            if (pressedProcessRecords != null && pressedProcessRecords.size() != 0){
                pressedProcessRecord = pressedProcessRecords.get(0);
                BeanUtils.copyProperties(pressedProcessRecord,pressedProcessRecordVo);
                return pressedProcessRecordVo;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("获取单个压型信息出现异常");
        }
    }
}
