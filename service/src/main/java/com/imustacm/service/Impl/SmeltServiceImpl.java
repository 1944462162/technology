package com.imustacm.service.Impl;

import com.imustacm.dao.SmeltDao;
import com.imustacm.domain.Po.Smelt;
import com.imustacm.service.SmeltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("smeltService")
public class SmeltServiceImpl implements SmeltService {


    @Autowired
    private SmeltDao dao;

    @Override
    public List<Smelt> getAllSmelt() throws Exception {
        List<Smelt> result=null;

        List<Smelt> smelts = dao.selectEntryList(null);
        if(smelts!=null  &&   smelts.size()!=0 )
        {
            for (Smelt Smelt1:smelts)
                result.add(Smelt1);
        }

        return result;
    }

    @Override
    public int insertSmelt(Smelt smelt) throws Exception {
        int isExist = dao.selectEntryListCount(smelt);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(smelt);
        return 1;
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
    public int updateSmelt(Smelt smelt) throws Exception {
        Smelt smelt1 = new Smelt();
        smelt1.setId(smelt.getId());
        Integer isExist = dao.selectEntryListCount(smelt1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(smelt);
        return 1;
    }

    @Override
    public Smelt getOneSmelt(int index) throws Exception {
        Smelt smelt = new Smelt();
        smelt.setId(index);
        List<Smelt> sparePartsList = dao.selectEntryList(smelt);
        if (sparePartsList.size() != 0){
            smelt = sparePartsList.get(0);
        }
        return smelt;
    }
}
