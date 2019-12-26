package com.imustacm.controller;

import com.imustacm.domain.Po.Product;
import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.ProductVo;
import com.imustacm.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2019/12/25 18:50
 * Content: 产品
 */
@RestController
@RequestMapping("/api")
@Api(tags = "产品库")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取所有的产品库")
    @GetMapping("/getAllProduct")
    public DefaultResponseVo getAllProduct(){

        List<ProductVo> productVos = productService.getALLProduct();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (productVos != null && productVos.size() != 0){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("Product",productVos);
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("产品信息为空");
        }
        return defaultResponseVo;
    }

    @ApiOperation("增加产品信息")
    @PostMapping("/insertProduct")
    public DefaultResponseVo insertProduct(@RequestBody ProductVo productVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = productService.insertProduct(productVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("增加产品信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("删除产品信息")
    @DeleteMapping("/deleteProduct/{index}")
    public DefaultResponseVo deleteProduct(@PathVariable("index") int index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = productService.deleteProdut(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除产品信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("更新产品信息")
    @PutMapping("/updateProduct")
    public DefaultResponseVo UpdateProduct(@RequestBody ProductVo productVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = productService.updateProduct(productVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新产品信息失败");
        }
        return defaultResponseVo;
    }

    @ApiOperation("获取单个产品信息")
    @GetMapping("/getProductById/{index}")
    public DefaultResponseVo getProductBySerial(@PathVariable("index") String index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        ProductVo productVo = productService.getProductBySerial(index);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("product",productVo);
        defaultResponseVo.setCode(200);
        defaultResponseVo.setMsg("ok");
        defaultResponseVo.setData(hashMap);
        return defaultResponseVo;
    }
}
