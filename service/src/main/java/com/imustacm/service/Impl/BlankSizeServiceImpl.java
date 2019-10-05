package com.imustacm.service.Impl;

import com.imustacm.dao.BlankSizeDao;
import com.imustacm.domain.BlankSize;
import com.imustacm.service.BlankSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("blankSizeService")
public class BlankSizeServiceImpl implements BlankSizeService {

    @Autowired
    private BlankSizeDao dao;

    @Override
    public List<BlankSize> getAllBlankSize() throws Exception {
        List<BlankSize> result=null;

        List<BlankSize> blankSizes = dao.selectEntryList(null);
        if( blankSizes!=null && blankSizes.size()!=0  )
        {
            for ( BlankSize blankSizes1:blankSizes)
                result.add(blankSizes1);
        }

        return result;
    }

    @Override
    public int insertBlankSize(BlankSize blankSize) throws Exception {
        int isExist = dao.selectEntryListCount(blankSize);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(blankSize);
        return 1;
    }

    @Override
    public int deleteBlankSizeById(int index) throws Exception {
        BlankSize blankSize = new BlankSize();
        blankSize.setId(index);
        Integer isExist = dao.selectEntryListCount(blankSize);
        if(isExist == 1){
            dao.deleteByKey(blankSize);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateBlankSize(BlankSize blankSize) throws Exception {
        BlankSize blankSize1 = new BlankSize();
        blankSize1.setId( blankSize.getId());
        Integer isExist = dao.selectEntryListCount(blankSize1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(blankSize);
        return 1;
    }

    @Override
    public BlankSize getOneBlankSize(int index) throws Exception {
        BlankSize blankSize = new BlankSize();
        blankSize.setId(index);
        List<BlankSize> blankSizeList = dao.selectEntryList(blankSize);
        if (blankSizeList.size() != 0){
            blankSize = blankSizeList.get(0);
        }
        return blankSize;
    }
}
