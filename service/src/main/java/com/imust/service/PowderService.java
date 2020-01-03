package com.imust.service;

import com.imust.domain.Po.Powder;
import com.imust.domain.Vo.PowderVo;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/3 20:15
 * Content:
 */
public interface PowderService {

    List<PowderVo> getAllPowder();

    int UpdatePowderByCode(PowderVo powderVo);

    int DeletePowderByCode(int id);

    int insertPowder(PowderVo powderVo);

    PowderVo getPowerBySerial(String serial);
}
