package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/17 11:14
 * Content:
 */

@ApiModel("压型记录表")
@Data
public class PressureRecordVo {
    public PressureRecordVo() {
        //默认无参构造方法
    }
    private Integer id;

    // max length: 100
    private String number;

    private String pressNumber;

    private Date createTime;

    private Integer roughcastNumber;

    private String picking;

    private String singleProduct;

    // max length: 100
    private String toolsNumber;

    private String toolsSize;

    private String suppressPressure;

    private Date suppressTime;

    private String magnetizingCurrent;

    private Date magentizingTime;

    private String demagnetizationCurrent;

    private Date demagnetizatioTime;

    // max length: 100
    private String oxygenWeighingRoom;

    private String oxygenPackingRoom;

    private String starNitrogen;

    private String endNitrogen;

    // max length: 100
    private String operator;

    private String remarks;
}
