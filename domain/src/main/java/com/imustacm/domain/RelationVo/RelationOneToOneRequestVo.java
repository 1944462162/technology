package com.imustacm.domain.RelationVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Date: 2019/9/30 19:38
 * Content:创建一对一的关系
 */
@ApiModel("创建一对一关系，从前台接收传来的一对一数据（id）")
@Data
public class RelationOneToOneRequestVo {
    private int id1;

    private int id2;
}
