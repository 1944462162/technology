package com.imustacm.service;


import com.imustacm.domain.Po.BlankSize;

import java.util.List;

public interface BlankSizeService {
    List<BlankSize> getAllBlankSize() throws Exception;
    //增加原料库存
    int insertBlankSize(BlankSize blankSize) throws Exception;

    //根据ID删除原料库存
    int deleteBlankSizeById(int index) throws Exception;

    //更新原料库存
    int updateBlankSize(BlankSize blankSize) throws Exception;

    //根据ID获取原料库存
    BlankSize getOneBlankSize(int index) throws Exception;
}
