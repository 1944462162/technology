package com.imust.service;

import com.imust.domain.Vo.SalesVo;

import java.util.List;

/**
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
