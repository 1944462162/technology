package com.imustacm.service.Impl;

import com.imustacm.dao.StockDao;
import com.imustacm.domain.Po.Stock;
import com.imustacm.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 18:50
 * Content:原料库存的Service
 * 判断状态 0表示不成功， 1表示成功
 */
@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    StockDao stockDao;

    //获取所有的原料库存
    public List<Stock> getAllStoch() throws Exception {
        List<Stock> result = new ArrayList<Stock>();

        //填入null表示查询所有
        List<Stock> stocks = stockDao.selectEntryList(null);
        if(stocks != null && stocks.size() != 0){
            for (Stock stock : stocks) {
                result.add(stock);
            }
        }
        return result;
    }

    //插入原料库存
    public int insertStoch(Stock stock) throws Exception {

        //返回值是1，表示查到有
        int isExist = stockDao.selectEntryListCount(stock);
        if (isExist == 1){
            return 0;
        }
        stockDao.insertEntry(stock);
        return 1;
    }

    //删除原料库存通过Id
    public int deleteStochById(int index) throws Exception {
        Stock stock = new Stock();
        stock.setId(index);
        Integer isExist = stockDao.selectEntryListCount(stock);
        if(isExist == 1){
            stockDao.deleteByKey(stock);
            return 1;
        }
        return 0;
    }

    //更新原料库存
    public int updateStock(Stock stock) throws Exception {
        Stock stock1 = new Stock();
        stock1.setId(stock.getId());
        Integer isExist = stockDao.selectEntryListCount(stock1);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        // 如果存在就进行跟新
        stockDao.updateByKey(stock);
        return 1;
    }


    //根据Id值获取原料库存
    public Stock getOneStock(int index) throws Exception {
        Stock stock = new Stock();
        stock.setId(index);
        List<Stock> stockList = stockDao.selectEntryList(stock);
        if (stockList.size() != 0){
            stock = stockList.get(0);
        }
        return stock;
    }
}
