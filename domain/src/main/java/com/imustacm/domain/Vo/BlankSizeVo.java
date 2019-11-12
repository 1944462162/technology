package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("设计压坯尺寸")
@Data
public class BlankSizeVo {

    public BlankSizeVo() {
        //默认无参构造方法
    }


    @ApiModelProperty(value = "压坯尺寸表ID，无需前端传入，数据库递增")
    private Integer id;

    // max length: 100
    @ApiModelProperty(value = "序号", example = "A304")
    private String number;

    @ApiModelProperty(value = "压制", example = "53.6")
    private String suppress;

    @ApiModelProperty(value = "模宽", example = "56.3")
    private String modeWidth;
    @ApiModelProperty(value = "取向", example = "462.3")
    private String orientation;

}
