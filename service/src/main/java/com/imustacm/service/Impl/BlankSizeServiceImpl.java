package com.imustacm.service.Impl;

import com.imustacm.dao.BlankSizeDao;
import com.imustacm.dao.Impl.RelationshipDieAndBlankDaoImpl;
import com.imustacm.domain.Po.BlankSize;
import com.imustacm.domain.Po.RelationshipDieAndBlank;
import com.imustacm.domain.Vo.BlankSizeVo;
import com.imustacm.service.BlankSizeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("blankSizeService")
public class BlankSizeServiceImpl implements BlankSizeService {

    @Autowired
    private BlankSizeDao blankSizeDao;

    @Autowired
    private RelationshipDieAndBlankDaoImpl relationshipDieAndBlankDao;

    @Override
    public List<BlankSizeVo> getAllBlankSize() throws Exception {
        List<BlankSizeVo> result= new ArrayList<>();

        List<BlankSize> blankSizes = blankSizeDao.selectEntryList(null);
        if( blankSizes!=null && blankSizes.size()!=0  )
        {
            for ( BlankSize blankSizes1:blankSizes)
            {
                BlankSizeVo blankSizeVo = new BlankSizeVo();
                BeanUtils.copyProperties(blankSizes1,blankSizeVo);
                result.add(blankSizeVo);
            }
        }
        return result;
    }

    @Override
    public int insertBlankSize(BlankSizeVo blankSizeVo) throws Exception {

        BlankSize blankSize = new BlankSize();
        BeanUtils.copyProperties(blankSizeVo,blankSize);
        int isExist = blankSizeDao.selectEntryListCount(blankSize);
        if (isExist == 1){
            return 0;
        }
        return blankSizeDao.insertEntry(blankSize);
    }

    @Override
    public int deleteBlankSizeById(int index) throws Exception {
        BlankSize blankSize = new BlankSize();
        blankSize.setId(index);
        Integer isExist = blankSizeDao.selectEntryListCount(blankSize);
        if(isExist == 1){
            return blankSizeDao.deleteByKey(blankSize);
        }
        return 0;
    }

    @Override
    public int updateBlankSize(BlankSizeVo blankSizeVo) throws Exception {
        BlankSize blankSize = new BlankSize();
        blankSize.setId( blankSizeVo.getId());
        Integer isExist = blankSizeDao.selectEntryListCount(blankSize);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        BeanUtils.copyProperties(blankSizeVo,blankSize);
        return blankSizeDao.updateByKey(blankSize);
    }

    @Override
    public BlankSizeVo getOneBlankSize(int index) throws Exception {
        BlankSize blankSize = new BlankSize();
        blankSize.setId(index);
        BlankSizeVo blankSizeVo = new BlankSizeVo();
        List<BlankSize> blankSizeList = blankSizeDao.selectEntryList(blankSize);
        if (blankSizeList.size() != 0){
            blankSize = blankSizeList.get(0);
            BeanUtils.copyProperties(blankSize,blankSizeVo);
        }
        return blankSizeVo;
    }

    // 对表关系的增删改
    @Override
    public int insertRelationPressureAndBlank(int PressureId, int... BlankId) {
        if(PressureId != 0 && BlankId.length != 0){
            RelationshipDieAndBlank[] relationshipDieAndBlanks = new RelationshipDieAndBlank[BlankId.length];
            for (int i = 0; i < BlankId.length; i++) {
                RelationshipDieAndBlank relationshipDieAndBlank = new RelationshipDieAndBlank();
                relationshipDieAndBlank.setPressureRecordId(PressureId);
                relationshipDieAndBlank.setBlankSizeId(BlankId[i]);
                relationshipDieAndBlanks[i] = relationshipDieAndBlank;
            }

            return relationshipDieAndBlankDao.insertEntry(relationshipDieAndBlanks);
        }
        return 0;
    }

    @Override
    public int updateRelationPressureAndBlank(int PressureId, int... BlankId) throws Exception {
        if(PressureId == 0){
            return 0;
        }
        else{
            deleteRelationByPressureId(PressureId);
            insertRelationPressureAndBlank(PressureId,BlankId);
            return 1;
        }
    }

    @Override
    public int deleteOneRelation(int PressureId, int BlankId) throws Exception {
        if(PressureId == 0 && BlankId == 0){
            return 0;
        }
        RelationshipDieAndBlank relationshipDieAndBlank = new RelationshipDieAndBlank();
        relationshipDieAndBlank.setBlankSizeId(BlankId);
        relationshipDieAndBlank.setPressureRecordId(PressureId);
        return relationshipDieAndBlankDao.deleteByKey(relationshipDieAndBlank);
    }

    public int deleteRelationByPressureId(int PressureId) throws Exception {
        if(PressureId == 0){
            return 0;
        }
        else{
            RelationshipDieAndBlank relationshipDieAndBlank = new RelationshipDieAndBlank();
            relationshipDieAndBlank.setPressureRecordId(PressureId);
            return relationshipDieAndBlankDao.deleteByKey(relationshipDieAndBlank);
        }
    }

}
