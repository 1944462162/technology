package com.imustacm.domain.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2019/10/16 14:41
 * Content:
 */

@ApiModel("原料库存基本信息")
@Data
public class StockVo {

    public StockVo() {
        //设置无参构造函数
    }

    @ApiModelProperty(value = "原料库存id",example = "1")
    private Integer id;

    // max length: 80
    @ApiModelProperty(value = "原料名称",example = "铁")
    private String stockName;

    @ApiModelProperty(value = "单位", example = "kg")
    private String company;

    @ApiModelProperty(value = "初期", example = "91.569")
    private String initialStage;

    @ApiModelProperty(value = "增加", example = "3274.65")
    private String increase;

    @ApiModelProperty(value = "减少", example = "200.64")
    private String reduce;

    @ApiModelProperty(value = "重量,计算得出前端无需插入")
    private String weight;

    @ApiModelProperty(value = "更新时间，前端无需写此操作")
    private Date createTime;
}
