package com.imustacm.service.Impl;

import com.imustacm.dao.SmeltDao;
import com.imustacm.domain.Po.Smelt;
import com.imustacm.domain.Vo.SmeltVo;
import com.imustacm.service.SmeltService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("smeltService")
public class SmeltServiceImpl implements SmeltService {


    @Autowired
    private SmeltDao dao;

    @Override
    public List<SmeltVo> getAllSmelt() throws Exception {
        List<SmeltVo> result = new ArrayList<>();

        List<Smelt> smelts = dao.selectEntryList(null);
        if(smelts!=null && smelts.size()!=0 )
        {
            for (Smelt Smelt1:smelts) {
                SmeltVo smeltVo = new SmeltVo();
                BeanUtils.copyProperties(Smelt1, smeltVo);
                result.add(smeltVo);
            }
        }

        return result;
    }

    @Override
    public int insertSmelt(SmeltVo smeltVo) throws Exception {
        Smelt smelt = new Smelt();
        BeanUtils.copyProperties(smeltVo,smelt);
        int isExist = dao.selectEntryListCount(smelt);
        if (isExist == 1){
            return 0;
        }
        return dao.insertEntry(smelt);
    }

    @Override
    public int deleteSmeltById(int index) throws Exception {
        Smelt smelt = new Smelt();
        smelt.setId(index);
        Integer isExist = dao.selectEntryListCount(smelt);
        if(isExist == 1){
            dao.deleteByKey(smelt);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateSmelt(SmeltVo smeltVo) throws Exception {
        Smelt smelt1 = new Smelt();
        smelt1.setId(smeltVo.getId());
        Integer isExist = dao.selectEntryListCount(smelt1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        BeanUtils.copyProperties(smeltVo,smelt1);
        dao.updateByKey(smelt1);
        return 1;
    }

    @Override
    public SmeltVo getOneSmelt(int index) throws Exception {
        Smelt smelt = new Smelt();
        smelt.setId(index);
        List<Smelt> sparePartsList = dao.selectEntryList(smelt);
        if (sparePartsList.size() != 0){
            smelt = sparePartsList.get(0);
        }
        SmeltVo smeltVo =  new SmeltVo();
        BeanUtils.copyProperties(smelt,smeltVo);
        return smeltVo;
    }
}
