package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

@ApiModel("冶炼操作记录信息")
@Data
public class SmeltingRecordVo {

    @ApiModelProperty(value = "冶炼操作记录id", example = "1")
    private Integer id;

    // max length: 100
    @ApiModelProperty(value = "编号", example = "335")
    private String number;

    @ApiModelProperty(value = "创建时间,无需前端输入")
    private String createTime;

    // max length: 100
    @ApiModelProperty(value = "操作人员", example = "张三")
    private String operator;

    @ApiModelProperty(value = "料包总重", example = "53.9")
    private String rawMaterialAllUp;

    @ApiModelProperty(value = "中间料包重", example = "65.3")
    private String tundishMaterial;

    @ApiModelProperty(value = "该坩埚使用炉次", example = "6")
    private Integer crucibleCount;

    // max length: 100
    @ApiModelProperty(value = "操作步骤",example = "烘料")
    private String operationSteps;

    @ApiModelProperty(value = "时间", example = "")
    private String operationTime;

    @ApiModelProperty(value = "真空度", example = "69.6")
    private String vacuum;

    @ApiModelProperty(value = "加热功率", example = "73.5")
    private String heatPower;

    @ApiModelProperty(value = "温度", example = "35.6")
    private String temperature;

    @ApiModelProperty(value = "水流量", example = "36.5")
    private String discharge;

    @ApiModelProperty(value = "水温", example = "27.6")
    private String waterTemperature;

    // max length: 400
    @ApiModelProperty(value = "备注", example = "成功")
    private String remarks;

    @ApiModelProperty(value = "第几行", example = "1")
    private Integer row;

    public SmeltingRecordVo() {
        // 设置无参构造函数
    }
}
