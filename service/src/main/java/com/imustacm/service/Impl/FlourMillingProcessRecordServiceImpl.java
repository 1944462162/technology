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
    public List<FlourMillingProcessRecordVo> getAllFlourMillingProcessRecord() {
        List<FlourMillingProcessRecordVo> result= new ArrayList<>();

        List<FlourMillingProcessRecord> flourMillingProcessRecords = null;
        try {
            flourMillingProcessRecords = flourMillingProcessRecordDao.selectEntryList(null);
            if(flourMillingProcessRecords!=null  && flourMillingProcessRecords.size()!=0  )
            {
                for (FlourMillingProcessRecord flourMillingProcessRecords1:flourMillingProcessRecords){
                    FlourMillingProcessRecordVo flourMillingProcessRecordVo = new FlourMillingProcessRecordVo();
                    BeanUtils.copyProperties(flourMillingProcessRecords1,flourMillingProcessRecordVo);
                    result.add(flourMillingProcessRecordVo);
                }
            }
            return result;
        } catch (Exception e) {
           throw new RuntimeException("获取所有制粉工艺记录信息失败");
        }

    }

    @Override
    public int insertFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) {

        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        BeanUtils.copyProperties(flourMillingProcessRecordVo,flourMillingProcessRecord);

        try {
            Integer isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
            if (isExist == 1){
                return 0;
            }

            return flourMillingProcessRecordDao.insertEntry(flourMillingProcessRecord);
        } catch (Exception e) {
           throw new RuntimeException("插入制粉信息失败");
        }

    }

    @Override
    public int deleteFlourMillingProcessRecordById(int index){
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        Integer isExist = null;
        try {
            isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
            if(isExist == 1){
                return flourMillingProcessRecordDao.deleteByKey(flourMillingProcessRecord);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("删除所有信息失败");
        }

    }

    @Override
    public int updateFlourMillingProcessRecord(FlourMillingProcessRecordVo flourMillingProcessRecordVo) {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(flourMillingProcessRecordVo.getId());
        Integer isExist = null;
        try {
            isExist = flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            BeanUtils.copyProperties(flourMillingProcessRecordVo,flourMillingProcessRecord);
            // 如果存在就进行跟新
            return flourMillingProcessRecordDao.updateByKey(flourMillingProcessRecord);
        } catch (Exception e) {
           throw new RuntimeException("更新所有信息失败");
        }

    }

    @Override
    public FlourMillingProcessRecordVo getOneFlourMillingProcessRecord(int index) {
        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
        flourMillingProcessRecord.setId(index);
        FlourMillingProcessRecordVo flourMillingProcessRecordVo = new FlourMillingProcessRecordVo();
        List<FlourMillingProcessRecord> flourMillingProcessRecordList = null;
        try {
            flourMillingProcessRecordList = flourMillingProcessRecordDao.selectEntryList(flourMillingProcessRecord);
            if (flourMillingProcessRecordList.size() != 0){
                flourMillingProcessRecord = flourMillingProcessRecordList.get(0);
                BeanUtils.copyProperties(flourMillingProcessRecord,flourMillingProcessRecordVo);
            }
            return flourMillingProcessRecordVo;
        } catch (Exception e) {
            throw new RuntimeException("获取单个制粉工艺信息失败");
        }

    }
}
