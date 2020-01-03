package com.imust.service.Impl;

import com.imust.dao.ProductDao;
import com.imust.domain.Po.Product;
import com.imust.domain.Vo.ProductVo;
import com.imust.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/12/25 16:37
 * Content:
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductVo> getALLProduct() {
        List<ProductVo> productVos = new ArrayList<>();
        try {
            List<Product> products = productDao.selectEntryList(null);
            if (products != null && products.size() != 0){
                for (Product product : products) {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(product,productVo);
                    productVos.add(productVo);
                }
            }

            return productVos;
        } catch (Exception e) {
            throw new RuntimeException("获取所有的产品信息出现异常");
        }
    }

    @Override
    public int insertProduct(ProductVo productVo) {
        Product product = new Product();
        BeanUtils.copyProperties(productVo,product);
        try {
            Integer isExist = productDao.selectEntryListCount(product);
            if (isExist ==  1){
                return 0;
            }
            return productDao.insertEntry(product);
        } catch (Exception e) {
           throw new RuntimeException("插入产品信息失败");
        }
    }

    @Override
    public int deleteProdut(int index) {
        Product product = new Product();
        product.setId(index);
        try {
            Integer isExist = productDao.selectEntryListCount(product);
            if (isExist == 1){
               return productDao.deleteByKey(product);
            }
            return 0;
        } catch (Exception e) {
           throw new RuntimeException("删除产品信息出现异常");
        }
    }

    @Override
    public int updateProduct(ProductVo productVo) {
        Product product = new Product();
        product.setId(productVo.getId());
        try {
            Integer isExist = productDao.selectEntryListCount(product);
            if (isExist == 1){
                BeanUtils.copyProperties(productVo,product);
                return productDao.updateByKey(product);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("更新产品信息出现异常");
        }
    }

    @Override
    public ProductVo getProductBySerial(String index) {
        Product product = new Product();
        product.setSerial(index);
        ProductVo productVo = new ProductVo();
        
        try {
            List<Product> products = productDao.selectEntryList(product);
            if (products.size() != 0){
                Product product1 = products.get(0);
                BeanUtils.copyProperties(product1,productVo);
            }
            return productVo;

        } catch (Exception e) {
           throw new RuntimeException("获取产品信息失败");
        }

    }
}
