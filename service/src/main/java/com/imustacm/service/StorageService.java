package com.imustacm.service;

import com.imustacm.domain.Po.Storage;
import com.imustacm.domain.Vo.StorageVo;

import java.util.List;

/**
 * Date: 2019/12/23 21:06
 * Content: 入库表
 */
public interface StorageService {

    //获取所有的入库信息
    List<StorageVo> getAllStorage();

    //增加入库数量
    int insertStorage(StorageVo storageVo);

    // 根据Id删除入库数量
    int deleteStorage(int index);

    // 更新原料库存
    int updateStorage(StorageVo storageVo);

    // 根据Id获取所有的入库信息
    StorageVo getStorageById(int index);
}
