package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

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
    @ApiModelProperty(value = "压型记录表的id",example = "1")
    private Integer id;

    // max length: 100
    @ApiModelProperty(value = "编号", example = "234")
    private String number;

    @ApiModelProperty(value = "压机编号", example = "663")
    private String pressNumber;

    @ApiModelProperty(value = "日期，无需从前端传入")
    private String createTime;

    @ApiModelProperty(value = "毛坯数量", example = "3")
    private Integer roughcastNumber;

    @ApiModelProperty(value = "领料", example = "33.6")
    private String picking;

    @ApiModelProperty(value = "产品单重", example = "6.3")
    private String singleProduct;

    // max length: 100
    @ApiModelProperty(value = "磨具编号", example = "A336")
    private String toolsNumber;

    @ApiModelProperty(value = "磨具尺寸", example = "336.2")
    private String toolsSize;

    @ApiModelProperty(value = "压制压力", example = "66.2")
    private String suppressPressure;

    @ApiModelProperty(value = "压制时间, 先不用从前端传入")
    private String suppressTime;

    @ApiModelProperty(value = "充磁电流", example = "223")
    private String magnetizingCurrent;

    @ApiModelProperty(value = "充磁时间，先不用从前端传入")
    private String magentizingTime;

    @ApiModelProperty(value = "退磁电流", example = "336")
    private String demagnetizationCurrent;

    @ApiModelProperty(value = "退磁时间, 先不用从前端传入")
    private String demagnetizatioTime;

    // max length: 100
    @ApiModelProperty(value = "含氧量，称料室", example = "233")
    private String oxygenWeighingRoom;

    @ApiModelProperty(value = "含氧量，包装室", example = "366")
    private String oxygenPackingRoom;

    @ApiModelProperty(value = "开始氧气量", example = "663")
    private String starNitrogen;

    @ApiModelProperty(value = "结束氧气量", example = "426")
    private String endNitrogen;

    // max length: 100
    @ApiModelProperty(value = "操作人", example = "李四")
    private String operator;

    @ApiModelProperty(value = "备注", example = "记录完成")
    private String remarks;
}
