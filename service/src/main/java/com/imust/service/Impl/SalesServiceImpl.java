package com.imust.service.Impl;

import com.imust.dao.SalesDao;
import com.imust.domain.Po.Sales;
import com.imust.domain.Vo.SalesVo;
import com.imust.service.SalesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/12/25 19:51
 * Content:
 */

@Service("salesService")
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Override
    public List<SalesVo> getAllSales() {

        List<SalesVo> salesVos = new ArrayList<>();
        try {
            List<Sales> sales = salesDao.selectEntryList(null);
            if (sales != null && sales.size() != 0){
                for (Sales sale : sales) {
                    SalesVo salesVo = new SalesVo();
                    BeanUtils.copyProperties(sale,salesVo);
                    salesVos.add(salesVo);
                }
            }
            return salesVos;
        } catch (Exception e) {
            throw new RuntimeException("获取所有销售库信息出现异常");
        }
    }

    @Override
    public int insertSales(SalesVo salesVo) {
        Sales sales = new Sales();
        BeanUtils.copyProperties(salesVo,sales);
        try {
            Integer isExist = salesDao.selectEntryListCount(sales);
            if (isExist == 1){
                return 0;
            }
            return salesDao.insertEntry(sales);
        } catch (Exception e) {
            throw new RuntimeException("查入销售库信息出现异常");
        }
    }

    @Override
    public int deleteSales(int index) {
        Sales sales = new Sales();
        sales.setId(index);
        try {
            Integer isExist = salesDao.selectEntryListCount(sales);
            if (isExist == 1){
                return salesDao.deleteByKey(sales);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("删除销售库信息出现异常");
        }

    }

    @Override
    public int updateSales(SalesVo salesVo) {
        Sales sales = new Sales();
        sales.setId(salesVo.getId());
        try {
            Integer isExist = salesDao.selectEntryListCount(sales);
            if (isExist == 1){
                BeanUtils.copyProperties(salesVo,sales);
                return salesDao.updateByKey(sales);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("更新销售库信息出现异常");
        }
    }

    @Override
    public SalesVo getSalesBySerial(String index) {
        Sales sales = new Sales();
        sales.setSerial(index);
        SalesVo salesVo = new SalesVo();
        try {
            List<Sales> salesList = salesDao.selectEntryList(sales);
            if (salesList != null && salesList.size() != 0){
                sales = salesList.get(0);
                BeanUtils.copyProperties(sales,salesVo);
            }
            return salesVo;
        } catch (Exception e) {
            throw new RuntimeException("获取单个信息出现异常");
        }
    }
}
