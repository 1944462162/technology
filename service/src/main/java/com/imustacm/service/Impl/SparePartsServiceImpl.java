package com.imustacm.service.Impl;

import com.imustacm.dao.SparePartsDao;
import com.imustacm.domain.SpareParts;
import com.imustacm.service.SparePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sparePartsService")
public class SparePartsServiceImpl implements SparePartsService {


    @Autowired
    private SparePartsDao dao=null;

    public List<SpareParts> getAllSpareParts() throws Exception {

        List<SpareParts> result=null;

        List<SpareParts> spareParts = dao.selectEntryList(null);
        if( spareParts!=null && spareParts.size()!=0 )
        {
            for (SpareParts spareParts1:spareParts)
                result.add(spareParts1);

        }

        return result;



    }

    public int insertSpareParts(SpareParts spareParts) throws Exception {
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

    public int updateSpareParts(SpareParts spareParts) throws Exception {
        SpareParts spareParts1 = new SpareParts();
        spareParts1.setId(spareParts.getId());
        Integer isExist = dao.selectEntryListCount(spareParts1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        dao.updateByKey(spareParts);
        return 1;
    }

    public SpareParts getOneSpareParts(int index) throws Exception {
        SpareParts stock = new SpareParts();
        stock.setId(index);
        List<SpareParts> sparePartsList = dao.selectEntryList(stock);
        if (sparePartsList.size() != 0){
            stock = sparePartsList.get(0);
        }
        return stock;
    }
}
