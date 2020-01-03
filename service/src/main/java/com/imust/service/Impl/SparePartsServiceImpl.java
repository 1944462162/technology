package com.imust.service.Impl;

import com.imust.dao.SparePartsDao;
import com.imust.domain.Po.SpareParts;
import com.imust.domain.Vo.SparePartsVo;
import com.imust.service.SparePartsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("sparePartsService")
public class SparePartsServiceImpl implements SparePartsService {

    @Autowired
    private SparePartsDao sparePartsDao;

    public List<SparePartsVo> getAllSpareParts() {

        List<SparePartsVo> result= new ArrayList<>();
        try {
            List<SpareParts> spareParts = sparePartsDao.selectEntryList(null);
            if( spareParts!=null && spareParts.size()!=0 )
            {
                for (SpareParts spareParts1:spareParts){
                    SparePartsVo sparePartsVo = new SparePartsVo();
                    BeanUtils.copyProperties(spareParts1,sparePartsVo);
                    result.add(sparePartsVo);
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取所有信息出现异常");
        }

    }

    public int insertSpareParts(SparePartsVo sparePartsVo) {

        SpareParts spareParts = new SpareParts();
        BeanUtils.copyProperties(sparePartsVo,spareParts);
        //返回值是1，表示查到有
        try {
            Integer isExist = sparePartsDao.selectEntryListCount(spareParts);
            if (isExist == 1){
                return 0;
            }
            return sparePartsDao.insertEntry(spareParts);
        } catch (Exception e) {
            throw new RuntimeException("插入信息出现异常");
        }

    }

    public int deleteSparePartsById(int index) {
        SpareParts stock = new SpareParts();
        stock.setId(index);
        try {
            Integer isExist = sparePartsDao.selectEntryListCount(stock);
            if(isExist == 1){

                return sparePartsDao.deleteByKey(stock);
            }
            return 0;
        } catch (Exception e) {
           throw new RuntimeException("删除信息出现异常");
        }

    }

    public int updateSpareParts(SparePartsVo sparePartsVo) {
        SpareParts spareParts1 = new SpareParts();
        spareParts1.setId(sparePartsVo.getId());

        try {
            Integer isExist = sparePartsDao.selectEntryListCount(spareParts1);
            //如果不存在返回0
            if(isExist == 0)
            {
                return 0;
            }
            // 如果存在就进行跟新
            BeanUtils.copyProperties(sparePartsVo,spareParts1);
            return sparePartsDao.updateByKey(spareParts1);
        } catch (Exception e) {
            throw new RuntimeException("跟新出现异常");
        }

    }

    public SparePartsVo getOneSpareParts(int index) {
        SpareParts spareParts = new SpareParts();
        spareParts.setId(index);

        try {
            List<SpareParts> sparePartsList = sparePartsDao.selectEntryList(spareParts);
            SparePartsVo sparePartsVo = new SparePartsVo();
            if (sparePartsList.size() != 0){
                spareParts = sparePartsList.get(0);
                BeanUtils.copyProperties(spareParts,sparePartsVo);
            }
            return sparePartsVo;
        } catch (Exception e) {
           throw new RuntimeException("获取单个备料信息失败");
        }

    }

    // 根据编号获取信息
    @Override
    public SparePartsVo getSparePartsByCode(String note) {

        SpareParts spareParts = new SpareParts();
        spareParts.setSerial(note);
        try {
            List<SpareParts> sparePartsList = sparePartsDao.selectEntryList(spareParts);
            SparePartsVo sparePartsVo = new SparePartsVo();
            if(sparePartsList != null  && sparePartsList.size()!=0)
            {
                spareParts = sparePartsList.get(0);
                BeanUtils.copyProperties(spareParts,sparePartsVo);
            }
            return sparePartsVo;
        } catch (Exception e) {
           throw new RuntimeException("根据备料号码获取信息出现异常");
        }

    }
}
