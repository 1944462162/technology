package com.imust.service.Impl;

import com.imust.dao.AgglomerationProcessRecordDao;
import com.imust.domain.Po.AgglomerationProcessRecord;
import com.imust.domain.Vo.AgglomerationProcessRecordVo;
import com.imust.service.AgglomerationProcessRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("agglomerationProcessRecordService")
public class AgglomerationProcessRecordServiceImpl implements AgglomerationProcessRecordService {


    @Autowired
    private AgglomerationProcessRecordDao agglomerationProcessRecordDao;


    @Override
    public List<AgglomerationProcessRecordVo> getAllAgglomerationProcessRecord() {
        List<AgglomerationProcessRecordVo> result= new ArrayList<>();

        List<AgglomerationProcessRecord> agglomerationProcessRecords = null;
        try {
            agglomerationProcessRecords = agglomerationProcessRecordDao.selectEntryList(null);
            if(agglomerationProcessRecords!=null && agglomerationProcessRecords.size()!=0)
            {
                for (AgglomerationProcessRecord agglomerationProcessRecord:agglomerationProcessRecords)
                {
                    AgglomerationProcessRecordVo agglomerationProcessRecordVo = new AgglomerationProcessRecordVo();
                    BeanUtils.copyProperties(agglomerationProcessRecord,agglomerationProcessRecordVo);
                    result.add(agglomerationProcessRecordVo);
                }
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取所有烧结工艺记录信息出现异常");
        }

    }

    @Override
    public int insertAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) {
       AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
       BeanUtils.copyProperties(agglomerationProcessRecordVo,agglomerationProcessRecord);
        int isExist = 0;
        try {
            isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
            if (isExist == 1){
                return 0;
            }
            return agglomerationProcessRecordDao.insertEntry(agglomerationProcessRecord);
        } catch (Exception e) {
            throw new RuntimeException("插入烧结工艺信息出现异常");
        }

    }

    @Override
    public int deleteAgglomerationProcessRecordById(int index) {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId(index);
        Integer isExist = null;
        try {
            isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
            if(isExist == 1){
                return agglomerationProcessRecordDao.deleteByKey(agglomerationProcessRecord);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("删除烧结工艺信息出现异常");
        }

    }

    @Override
    public int updateAgglomerationProcessRecord(AgglomerationProcessRecordVo agglomerationProcessRecordVo) {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        agglomerationProcessRecord.setId( agglomerationProcessRecordVo.getId());
        Integer isExist = null;
        try {
            isExist = agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            // 如果存在就进行跟新
            BeanUtils.copyProperties(agglomerationProcessRecordVo,agglomerationProcessRecord);
            return agglomerationProcessRecordDao.updateByKey(agglomerationProcessRecord);
        } catch (Exception e) {
            throw new RuntimeException("更新烧结工艺记录信息出现异常");
        }

    }

    @Override
    public AgglomerationProcessRecordVo getOneAgglomerationProcessRecord(int index) {
        AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
        AgglomerationProcessRecordVo agglomerationProcessRecordVo = new AgglomerationProcessRecordVo();
        agglomerationProcessRecord.setId(index);
        List<AgglomerationProcessRecord> blankSizeList = null;
        try {
            blankSizeList = agglomerationProcessRecordDao.selectEntryList(agglomerationProcessRecord);
            if (blankSizeList.size() != 0){
                agglomerationProcessRecord = blankSizeList.get(0);
                BeanUtils.copyProperties(agglomerationProcessRecord,agglomerationProcessRecordVo);
            }
            return agglomerationProcessRecordVo;
        } catch (Exception e) {
            throw new RuntimeException("获取单个烧结工艺记录信息失败");
        }

    }



    @Override
    public int getNewInsertagglomerationProcessRecords() {
        int k = 0;
        try {
            List<AgglomerationProcessRecord> agglomerationProcessRecords = agglomerationProcessRecordDao.selectEntryList(null);
            for (AgglomerationProcessRecord agglomerationProcessRecord : agglomerationProcessRecords) {
                k = agglomerationProcessRecord.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

}
