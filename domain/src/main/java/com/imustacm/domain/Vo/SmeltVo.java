package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/16 21:02
 * Content:
 */

@ApiModel("冶炼表")
@Data
public class SmeltVo {

    public SmeltVo() {
        //默认无参构造方法
    }

    @ApiModelProperty(value = "冶炼表id")
    private Integer id;

    @ApiModelProperty(value = "日期，无需前端给出")
    private Date createTime;

    @ApiModelProperty(value = "编号", example = "255")
    // max length: 100
    private String number;

    @ApiModelProperty(value = "第一桶皮重", example = "264.3")
    private String fristTare;

    @ApiModelProperty(value = "第一桶净重", example = "463.2")
    private String fristNetWeight;

    @ApiModelProperty(value = "第二桶皮重", example = "263.9")
    private String secondTare;

    @ApiModelProperty(value = "第二桶净重", example = "432.6")
    private String secondNetWeight;

    @ApiModelProperty(value = "出料", example = "366.2")
    private String discharge;

    @ApiModelProperty(value = "入料", example = "533.49")
    private String feeding;

    @ApiModelProperty(value = "收率", example = "63.7")
    private String yield;

    // max length: 100
    @ApiModelProperty(value = "操作人", example = "张三")
    private String operator;
}
