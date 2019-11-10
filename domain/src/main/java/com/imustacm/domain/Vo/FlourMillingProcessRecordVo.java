package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/17 9:37
 * Content:
 */
@ApiModel("制粉工艺记录相关信息")
@Data
public class FlourMillingProcessRecordVo {

    public FlourMillingProcessRecordVo() {
        //默认无参构造方法
    }

    @ApiModelProperty(value = "制粉工艺记录表id", example = "1")
    private Integer id;

    // max length: 80
    @ApiModelProperty(value = "编号", example = "568")
    private String number;

    @ApiModelProperty(value = "操作人", example = "张三")
    private String operator;

    @ApiModelProperty(value = "创建时间，无需从前端传入")
    private String createTime;

    // max length: 400
    @ApiModelProperty(value = "设备运行情况", example = "良好")
    private String operationOfEquipment;

    @ApiModelProperty(value = "投料料重", example = "53.7")
    private String feedWeight;

    // max length: 400
    @ApiModelProperty(value = "投料说明", example = "投入50.3kg铁")
    private String feedInstructions;

    @ApiModelProperty(value = "制粉起始时间", example = "")
    private String millingStarTime;

    @ApiModelProperty(value = "制粉结束时间", example = "")
    private String millingEndTime;

    @ApiModelProperty(value = "制粉耗时", example = "")
    private String millingTime;

    @ApiModelProperty(value = "制粉起始氧含量", example = "1000")
    private String starOxygenContent;

    @ApiModelProperty(value = "制粉过程中氧气含量", example = "500")
    private String processOxygenContent;

    @ApiModelProperty(value = "制粉终了氧含量", example = "500")
    private String endOxygenContent;

    @ApiModelProperty(value = "分选机转速", example = "5000.56")
    private String speed;

    @ApiModelProperty(value = "研磨压力", example = "600.4")
    private String grindPressure;

    @ApiModelProperty(value = "制粉起始流量", example = "5000.5")
    private String millingStarFlow;

    @ApiModelProperty(value = "制粉终了流量", example = "6000.6")
    private String millingEndFlow;

    @ApiModelProperty(value = "出料料重", example = "3000.7")
    private String materialWeight;

    @ApiModelProperty(value = "吐料", example = "4000.5")
    private String spitting;

    @ApiModelProperty(value = "收率", example = "2000.4")
    private String yield;

    // max length: 400
    @ApiModelProperty(value = "备注", example = "正常")
    private String remarks;

}
