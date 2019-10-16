package com.imustacm.service.Impl;

import com.imustacm.dao.SparePartsDao;
import com.imustacm.domain.Po.SpareParts;
import com.imustacm.domain.Vo.SparePartsVo;
import com.imustacm.service.SparePartsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("sparePartsService")
public class SparePartsServiceImpl implements SparePartsService {


    @Autowired
    private SparePartsDao dao=null;

    public List<SparePartsVo> getAllSpareParts() throws Exception {

        List<SparePartsVo> result= new ArrayList<>();
        List<SpareParts> spareParts = dao.selectEntryList(null);
        if( spareParts!=null && spareParts.size()!=0 )
        {
            for (SpareParts spareParts1:spareParts){
                SparePartsVo sparePartsVo = new SparePartsVo();
                BeanUtils.copyProperties(spareParts1,sparePartsVo);
                result.add(sparePartsVo);
            }
        }
        return result;
    }

    public int insertSpareParts(SparePartsVo sparePartsVo) throws Exception {

        SpareParts spareParts = new SpareParts();
        BeanUtils.copyProperties(sparePartsVo,spareParts);
        //返回值是1，表示查到有
        int isExist = dao.selectEntryListCount(spareParts);
        if (isExist == 1){
            return 0;
        }
        dao.insertEntry(spareParts);
        return 1;
    }

    public int deleteSparePartsById(int index) throws Exception {
        SpareParts stock = new SpareParts();
        stock.setId(index);
        Integer isExist = dao.selectEntryListCount(stock);
        if(isExist == 1){
            dao.deleteByKey(stock);
            return 1;
        }
        return 0;
    }

    public int updateSpareParts(SparePartsVo sparePartsVo) throws Exception {
        SpareParts spareParts1 = new SpareParts();
        spareParts1.setId(sparePartsVo.getId());
        Integer isExist = dao.selectEntryListCount(spareParts1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(spareParts1);
        return 1;
    }

    public SparePartsVo getOneSpareParts(int index) throws Exception {
        SpareParts spareParts = new SpareParts();
        spareParts.setId(index);
        List<SpareParts> sparePartsList = dao.selectEntryList(spareParts);
        SparePartsVo sparePartsVo = new SparePartsVo();
        if (sparePartsList.size() != 0){
            spareParts = sparePartsList.get(0);
            BeanUtils.copyProperties(spareParts,sparePartsVo);
        }
        return sparePartsVo;
    }
}
