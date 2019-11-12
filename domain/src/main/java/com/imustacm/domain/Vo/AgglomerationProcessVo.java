package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@ApiModel("结烧工艺")
@Data
public class AgglomerationProcessVo {

    public AgglomerationProcessVo() {
        //默认无参构造方法
    }
    @ApiModelProperty(value = "结烧工艺的Id", example ="1")
    private Integer id;

    @ApiModelProperty(value = "创建时间,无需从前端传入")
    private String datatime;

    @ApiModelProperty(value = "累计时间，无需从前端传入")
    private String totalTime;

    // max length: 100
    @ApiModelProperty(value = "烧结过程",example = "煅烧")
    private String sinterProcess;

    @ApiModelProperty(value = "炉温",example = "35.6")
    private String furnaceTemperature;

    @ApiModelProperty(value = "真空度", example = "63.5")
    private String vacuumDegree;
}
