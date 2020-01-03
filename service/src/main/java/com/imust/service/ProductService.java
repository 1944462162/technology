package com.imust.service;

import com.imust.domain.Vo.ProductVo;

import java.util.List;

/**
 * Date: 2019/12/25 16:22
 * Content:
 */
public interface ProductService {
    List<ProductVo> getALLProduct();

    int insertProduct(ProductVo productVo);

    int deleteProdut(int index);

    int updateProduct(ProductVo productVo);

    ProductVo getProductBySerial(String index);
}
