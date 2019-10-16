package com.imustacm.domain.RelationVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 19:38
 * Content: 创建一对多的关系
 */

@ApiModel("创建一对多的关系，从前台接收数据（id值）")
@Data
public class RelationOneToManyRequestVo {

    @ApiModelProperty(value = "一对多模型中，'1'的数据",example = "1")
    private int oneId;
    @ApiModelProperty(value = "一对多模型中,'多'的数据",dataType = "int[]")
    private int[] manyId;
}
