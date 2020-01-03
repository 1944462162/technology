package com.imust.service.Impl;

import com.imust.dao.StockDao;
import com.imust.domain.Po.Stock;
import com.imust.domain.Vo.StockVo;
import com.imust.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断状态 0表示不成功， 1表示成功
 */
@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    //获取所有的原料库存
    public List<StockVo> getAllStock() {
        List<StockVo> result = new ArrayList<>();

        //填入null表示查询所有
        List<Stock> stocks = null;
        try {
            stocks = stockDao.selectEntryList(null);
            if(stocks != null && stocks.size() != 0){
                for (Stock stock : stocks) {
                    StockVo stockVo = new StockVo();
                    BeanUtils.copyProperties(stock,stockVo);
                    result.add(stockVo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //插入原料库存
    public int insertStock(StockVo stockVo) {

        Stock stock = new Stock();
        BeanUtils.copyProperties(stockVo,stock);
        try {
            Integer isExist = stockDao.selectEntryListCount(stock);
            if (isExist == 1){
                return 0;
            }
            return stockDao.insertEntry(stock);
        } catch (Exception e) {
           throw new RuntimeException("插入原料库存失败");
        }
    }

    //删除原料库存通过Id
    public int deleteStockById(int index) {
        Stock stock = new Stock();
        stock.setId(index);
        try {
            Integer isExist = stockDao.selectEntryListCount(stock);
            if(isExist == 1){
                return stockDao.deleteByKey(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //更新原料库存
    public int updateStock(StockVo stockVo) {
        Stock stock = new Stock();
        stock.setId(stockVo.getId());
        try {
            Integer isExist = stockDao.selectEntryListCount(stock);
            if(isExist == 0)
            {
                return 0;
            }
            BeanUtils.copyProperties(stockVo,stock);
            return stockDao.updateByKey(stock);
        } catch (Exception e) {
            throw new RuntimeException("跟新原料信息失败");
        }

    }

    //根据Id值获取原料库存
    public StockVo getOneStock(int index) {
        Stock stock = new Stock();
        stock.setId(index);
        try {
            List<Stock> stockList = stockDao.selectEntryList(stock);
            StockVo stockVo = new StockVo();
            if (stockList.size() != 0){
                stock = stockList.get(0);
                BeanUtils.copyProperties(stock,stockVo);
            }
            return stockVo;
        } catch (Exception e) {
           throw new RuntimeException("获取原料信息失败");
        }
    }
}
