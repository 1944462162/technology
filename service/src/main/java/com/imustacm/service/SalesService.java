package com.imustacm.service;

import com.imustacm.domain.Po.Sales;
import com.imustacm.domain.Vo.SalesVo;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/12/25 19:46
 * Content:
 */
public interface SalesService {

    List<SalesVo> getAllSales();

    int insertSales(SalesVo salesVo);

    int deleteSales(int index);

    int updateSales(SalesVo salesVo);

    SalesVo getSalesBySerial(String index);
}
