package com.imust.service.Impl;

import com.imust.dao.*;
import com.imust.domain.Po.*;
import com.imust.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 2019/12/30 9:54
 * Content: 显示进度条
 */
@Service("progressService")
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private SparePartsDao sparePartsDao;

    @Autowired
    private SmeltingRecordDao smeltingRecordDao;

    @Autowired
    private SmeltDao smeltDao;

    @Autowired
    private FlourMillingProcessRecordDao flourMillingProcessRecordDao;

    @Autowired
    private PressureRecordDao pressureRecordDao;

    @Autowired
    private AgglomerationProcessRecordDao agglomerationProcessRecordDao;

    @Autowired
    private ProductDao productDao;


    @Override
    public int progressbar(String serial) {
        SpareParts spareParts = new SpareParts();
        spareParts.setSerial(serial);
        try {
            if (1 ==  sparePartsDao.selectEntryListCount(spareParts)){
                SmeltingRecord smeltingRecord = new SmeltingRecord();
                smeltingRecord.setSerial(serial);
                if (1 == smeltingRecordDao.selectEntryListCount(smeltingRecord)){
                    Smelt smelt = new Smelt();
                    smelt.setSerial(serial);
                    if (1 == smeltDao.selectEntryListCount(smelt)){
                        FlourMillingProcessRecord flourMillingProcessRecord = new FlourMillingProcessRecord();
                        flourMillingProcessRecord.setSerial(serial);
                        if (1 == flourMillingProcessRecordDao.selectEntryListCount(flourMillingProcessRecord)){
                            PressureRecord pressureRecord = new PressureRecord();
                            pressureRecord.setSerial(serial);
                            if (1 == pressureRecordDao.selectEntryListCount(pressureRecord)){
                                AgglomerationProcessRecord agglomerationProcessRecord = new AgglomerationProcessRecord();
                                agglomerationProcessRecord.setSerial(serial);
                                if (1 == agglomerationProcessRecordDao.selectEntryListCount(agglomerationProcessRecord)){
                                    Product product = new Product();
                                    product.setSerial(serial);
                                    if (1 == productDao.selectEntryListCount(product)){
                                        return 7;
                                    }
                                }
                                else{
                                    return 6;
                                }
                            }
                            else{
                                return 5;
                            }
                        }
                        else {
                            return 4;
                        }
                    }
                    else {
                        return 3;
                    }
                }
                else{
                    return 2;
                }
            }
            else{
                return 1;
            }
        } catch (Exception e) {
            throw new RuntimeException("显示进度条失败！！！");
        }
        return -1;
    }
}
