package com.imustacm.controller;

import com.imustacm.domain.Po.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: wangJianBo
 * Date: 2019/10/25 11:17
 * Content:
 */

@Controller
public class UserController {
    @RequestMapping(value = "/sublogin", produces="application/json;charset=utf-8",method = RequestMethod.POST)

    public String sublogin(Users user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        return "welcome";
    }

    // admin角色：对所有表进行操作
    @RequiresPermissions({"stock"})
    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
    @ResponseBody
    public String adminRole(){
        return "admin";
    }

//    director角色：对所有的表进行操作
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord","blankSize","relationshipDieAndBlank","agglomerationProcessRecord","relationShipAgglomerationProcess","agglomerationProcess"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String directorRole(){
//        return "director";
//    }
////
//    //    scientific1角色
//    @RequiresPermissions({"stock","flourMillingProcessRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String scientificRole(){
//        return "scientific";
//    }
//
//    //    Sale角色，目前不清楚具体要求
//    @RequiresPermissions("stock")
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String SaleRole(){
//        return "scientific";
//    }
//
//    //    production1角色
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String productionRole(){
//        return "production";
//    }
}
