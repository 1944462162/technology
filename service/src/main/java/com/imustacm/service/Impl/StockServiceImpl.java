package com.imustacm.service.Impl;

import com.imustacm.dao.StockDao;

import com.imustacm.domain.Po.Stock;
import com.imustacm.domain.Vo.StockVo;
import com.imustacm.service.StockService;
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
    StockDao stockDao;

    //获取所有的原料库存
    public List<StockVo> getAllStock() throws Exception {
        List<StockVo> result = new ArrayList<>();

        //填入null表示查询所有
        List<Stock> stocks = stockDao.selectEntryList(null);
        if(stocks != null && stocks.size() != 0){
            for (Stock stock : stocks) {
                StockVo stockVo = new StockVo();
                BeanUtils.copyProperties(stock,stockVo);
                result.add(stockVo);
            }
        }
        return result;
    }

    //插入原料库存
    public int insertStock(StockVo stockVo) throws Exception {

        Stock stock = new Stock();
        BeanUtils.copyProperties(stockVo,stock);
        int isExist = stockDao.selectEntryListCount(stock);
        if (isExist == 1){
            return 0;
        }

        return stockDao.insertEntry(stock);
    }

    //删除原料库存通过Id
    public int deleteStockById(int index) throws Exception {
        Stock stock = new Stock();
        stock.setId(index);
        Integer isExist = stockDao.selectEntryListCount(stock);
        if(isExist == 1){

            return stockDao.deleteByKey(stock);
        }
        return 0;
    }

    //更新原料库存
    public int updateStock(StockVo stockVo) throws Exception {
        Stock stock = new Stock();
        stock.setId(stockVo.getId());
        Integer isExist = stockDao.selectEntryListCount(stock);
        //如果不存在返回0
        if(isExist == 0)
        {
            return 0;
        }
        BeanUtils.copyProperties(stockVo,stock);
        // 如果存在就进行跟新

        return stockDao.updateByKey(stock);
    }


    //根据Id值获取原料库存
    public StockVo getOneStock(int index) throws Exception {
        Stock stock = new Stock();
        stock.setId(index);
        List<Stock> stockList = stockDao.selectEntryList(stock);
        StockVo stockVo = new StockVo();
        if (stockList.size() != 0){
            stock = stockList.get(0);
            BeanUtils.copyProperties(stock,stockVo);
        }
        return stockVo;
    }
}
