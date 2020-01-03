package com.imust.service.Impl;

import com.imust.dao.SmeltDao;
import com.imust.domain.Po.Smelt;
import com.imust.domain.Vo.SmeltVo;
import com.imust.service.SmeltService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("smeltService")
public class SmeltServiceImpl implements SmeltService {


    @Autowired
    private SmeltDao smeltDao;

    @Override
    public List<SmeltVo> getAllSmelt() {
        List<SmeltVo> result = new ArrayList<>();

        try {
            List<Smelt> smelts = smeltDao.selectEntryList(null);
            if(smelts!=null && smelts.size()!=0 )
            {
                for (Smelt Smelt1:smelts) {
                    SmeltVo smeltVo = new SmeltVo();
                    BeanUtils.copyProperties(Smelt1, smeltVo);
                    result.add(smeltVo);
                }
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取所有冶炼操作记录出现异常");
        }

    }

    @Override
    public int insertSmelt(SmeltVo smeltVo) {
        Smelt smelt = new Smelt();
        BeanUtils.copyProperties(smeltVo,smelt);

        try {
            Integer isExist = smeltDao.selectEntryListCount(smelt);
            if (isExist == 1){
                return 0;
            }

            return smeltDao.insertEntry(smelt);
        } catch (Exception e) {
            throw new RuntimeException("插入信息失败");
        }


    }

    @Override
    public int deleteSmeltById(int index) {
        Smelt smelt = new Smelt();
        smelt.setId(index);
        try {
            Integer isExist = smeltDao.selectEntryListCount(smelt);
            if(isExist == 1){
                return smeltDao.deleteByKey(smelt);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("删除信息出现异常");
        }

    }

    @Override
    public int updateSmelt(SmeltVo smeltVo) {
        Smelt smelt1 = new Smelt();
        smelt1.setId(smeltVo.getId());
        Integer isExist = null;
        try {
            isExist = smeltDao.selectEntryListCount(smelt1);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            // 如果存在就进行跟新
            BeanUtils.copyProperties(smeltVo,smelt1);

            return smeltDao.updateByKey(smelt1);
        } catch (Exception e) {
            throw new RuntimeException("更新冶炼信息出现异常");
        }

    }

    @Override
    public SmeltVo getOneSmelt(int index) {
        Smelt smelt = new Smelt();
        smelt.setId(index);
        try {
            List<Smelt> sparePartsList = smeltDao.selectEntryList(smelt);
            if (sparePartsList.size() != 0){
                smelt = sparePartsList.get(0);
            }
            SmeltVo smeltVo =  new SmeltVo();
            BeanUtils.copyProperties(smelt,smeltVo);
            return smeltVo;
        } catch (Exception e) {
           throw new RuntimeException("获取单个信息失败");
        }

    }
}
