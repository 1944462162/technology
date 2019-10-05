package com.imustacm.domain.Vo;

import lombok.Data;

import java.util.HashMap;

/**
 * Author: wangJianBo
 * Date: 2019/9/30 19:33
 * Content: 创建返回前端的类
 */
@Data
public class DefaultResponseVo {
    int code;
    String msg;

    //扩展
    private HashMap<String,Object> data;

    //创建无参的构造函数
    public DefaultResponseVo(){

    }

    public DefaultResponseVo(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
