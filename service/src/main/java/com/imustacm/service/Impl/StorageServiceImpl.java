package com.imustacm.service.Impl;

import com.imustacm.dao.StorageDao;
import com.imustacm.domain.Po.Storage;
import com.imustacm.domain.Vo.StorageVo;
import com.imustacm.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/12/23 21:14
 * Content:
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public List<StorageVo> getAllStorage() {
        List<StorageVo> result = new ArrayList<>();
        try {
            List<Storage> storages = storageDao.selectEntryList(null);
           if (storages != null && storages.size() != 0){
               for (Storage storage : storages) {
                   StorageVo storageVo = new StorageVo();
                   BeanUtils.copyProperties(storage,storageVo);
                   result.add(storageVo);
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertStorage(StorageVo storageVo) {
        Storage storage = new Storage();
        BeanUtils.copyProperties(storageVo,storage);
        try {
            Integer isExist = storageDao.selectEntryListCount(storage);
            if (isExist == 1){
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return storageDao.insertEntry(storage);
        } catch (Exception e) {
            throw new RuntimeException("插入信息是发生异常");
        }
    }


    // 根据ID进行删除
    @Override
    public int deleteStorage(int index) {
        Storage storage = new Storage();
        storage.setId(index);
        try {
            Integer isExist = storageDao.selectEntryListCount(storage);
            if (isExist == 1){
                return storageDao.deleteByKey(storage);
            }
        } catch (Exception e) {
           throw new RuntimeException("根据Id删除失败");
        }
        return 0;
    }

    @Override
    public int updateStorage(StorageVo storageVo) {
        Storage storage = new Storage();
        storage.setId(storageVo.getId());
        try {
            Integer isExist = storageDao.selectEntryListCount(storage);
            if (isExist == 1){
                BeanUtils.copyProperties(storageVo,storage);
                return storageDao.updateByKey(storage);
            }
        } catch (Exception e) {
           throw new RuntimeException("跟新信息失败");
        }
        return 0;
    }

    @Override
    public StorageVo getStorageById(int index) {
        Storage storage = new Storage();
        storage.setId(index);
        try {
            List<Storage> storages = storageDao.selectEntryList(storage);
            if (storages.size() != 0){
                StorageVo storageVo = new StorageVo();
                storage = storages.get(0);
                BeanUtils.copyProperties(storage,storageVo);
                return storageVo;
            }
        } catch (Exception e) {
           throw new RuntimeException("根据ID获取信息失败");
        }
        return null;
    }

}
