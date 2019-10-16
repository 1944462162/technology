package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/16 16:24
 * Content:
 */

@ApiModel("备料基本信息")
@Data
public class SparePartsVo {

    public SparePartsVo() {
        //默认无参构造方法
    }
    @ApiModelProperty(value = "配料id", example = "1")
    private Integer id;

    // max length: 100
    @ApiModelProperty(value = "成分",example = "铁")
    private String component;

    @ApiModelProperty(value = "需求量", example = "216.3")
    private String requirement;

    @ApiModelProperty(value = "配料量", example = "56.4")
    private String dosage;

    // max length: 400
    @ApiModelProperty(value = "重要的标注", example = "成功配料")
    private String remarks;

    @ApiModelProperty(value = "创建时间，无需从前端传入")
    private Date createTime;

    @ApiModelProperty(value = "牌号", example = "234")
    private Integer brandName;

    // max length: 100
    @ApiModelProperty(value = "配料人", example = "张三")
    private String ingredientPerson;

    @ApiModelProperty(value = "复合人", example = "李四")
    private String reviewer;
}
