package com.imustacm.service;


import com.imustacm.domain.Po.BlankSize;
import com.imustacm.domain.Vo.BlankSizeVo;
import com.imustacm.domain.Vo.RelationshipDieAndBlankVo;

import java.util.List;

public interface BlankSizeService {
    List<BlankSizeVo> getAllBlankSize() throws Exception;
    //增加原料库存
    int insertBlankSize(BlankSizeVo blankSizeVo) throws Exception;

    //根据ID删除原料库存
    int deleteBlankSizeById(int index) throws Exception;

    //更新原料库存
    int updateBlankSize(BlankSizeVo blankSizeVo) throws Exception;

    //根据ID获取原料库存
    BlankSizeVo getOneBlankSize(int index) throws Exception;

    int insertRelationPressureAndBlank(int PressureId, int... BlankId) throws Exception;

    int updateRelationPressureAndBlank(int PressureId, int... BlankId) throws Exception;

    int deleteOneRelation(int PressureId, int BlankId) throws Exception;

    List<RelationshipDieAndBlankVo> getAllRelation() throws Exception;
}
