package com.imust.service.Impl;

import com.imust.dao.PowderDao;
import com.imust.domain.Po.Powder;
import com.imust.domain.Vo.PowderVo;
import com.imust.service.PowderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2020/1/3 20:14
 * Content:
 */
@Service("powderService")
public class PowderServiceImpl implements PowderService {

    @Autowired
    PowderDao powderDao;
    @Override
    public List<PowderVo> getAllPowder() {
        List<PowderVo> powderVos = new ArrayList<>();
        try {
            List<Powder> powders = powderDao.selectEntryList(null);
            if (powders != null && powders.size() != 0){
                for (Powder powder : powders) {
                    PowderVo powderVo = new PowderVo();
                    BeanUtils.copyProperties(powder,powderVo);
                    powderVos.add(powderVo);
                }
                return powderVos;
            }
            else{
                return null;
            }
        } catch (Exception e) {
           throw new RuntimeException("获取所有入粉库信息失败");
        }

    }

    @Override
    public int UpdatePowderByCode(PowderVo powderVo) {

        Powder powder = new Powder();
        powder.setId(powderVo.getId());
        try {
            Integer isExist = powderDao.selectEntryListCount(powder);
            if (isExist == 1){
                BeanUtils.copyProperties(powderVo,powder);
                return powderDao.updateByKey(powder);
            }
            else{
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("更新入粉信息出现异常");
        }
    }

    @Override
    public int DeletePowderByCode(int id) {
        Powder powder = new Powder();
        powder.setId(id);
        try {
            Integer isExist = powderDao.selectEntryListCount(powder);
            if (isExist == 0){
                return 0;
            }
            return powderDao.deleteByKey(powder);
        } catch (Exception e) {
            throw new RuntimeException("删除粉入库信息失败");
        }
    }

    @Override
    public int insertPowder(PowderVo powderVo) {
        Powder powder = new Powder();
        BeanUtils.copyProperties(powderVo,powder);
        try {
            Integer isExsit = powderDao.selectEntryListCount(powder);
            if (isExsit == 1){
                return 0;
            }
            return powderDao.insertEntry(powder);
        } catch (Exception e) {
            throw new RuntimeException("增加入库信息失败");
        }
    }

    @Override
    public PowderVo getPowerBySerial(String serial) {

        PowderVo powderVo = new PowderVo();
        Powder powder = new Powder();
        powder.setSerial(serial);
        try {
            List<Powder> powders = powderDao.selectEntryList(powder);
            if (powders != null && powders.size() != 0){
                powder = powders.get(0);
                BeanUtils.copyProperties(powder,powderVo);
                return powderVo;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("获取粉库信息失败");
        }
    }
}
