package com.imust.controller;

import com.imust.domain.Po.Users;
import com.imust.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/sublogin", produces="application/json;charset=utf-8",method = RequestMethod.POST)
    public String sublogin(Users user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            return e.getMessage();
        }

        return "welcome";
    }

    // admin角色：对所有表进行操作
    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord","blankSize","relationshipDieAndBlank","agglomerationProcessRecord","relationShipAgglomerationProcess","agglomerationProcess"})
    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
    @ResponseBody
    public String adminRole(){
        return "admin";
    }

////    director角色：对所有的表进行操作
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord","blankSize","relationshipDieAndBlank","agglomerationProcessRecord","relationShipAgglomerationProcess","agglomerationProcess"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String directorRole(){
//        return "director";
//    }
//////
//    //    scientific1角色
//    @RequiresPermissions({"stock","flourMillingProcessRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String scientificOneRole(){
//        return "scientific";
//    }
//
//    //    scientific2角色
//    @RequiresPermissions({"stock","flourMillingProcessRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String scientificTwoRole(){
//        return "scientific";
//    }
//
//
////
//    //    Sale角色，目前不清楚具体要求
//    @RequiresPermissions("stock")
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String SaleRole(){
//        return "scientific";
//    }
////
//    //    production1角色
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String productionOneRole(){
//        return "production";
//    }
//
//    //    production2角色
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String productionTwoRole(){
//        return "production";
//    }
//
//    //    production3角色
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String productionThreeRole(){
//        return "production";
//    }
//
//    //    production4角色
//    @RequiresPermissions({"stock","spareParts","smeltingRecord","smeltingRecord","smelt","flourMillingProcessRecord","pressureRecord"})
//    @RequestMapping(value = "/adminShiro", method = RequestMethod.GET)
//    @ResponseBody
//    public String productionFourRole(){
//        return "production";
//    }




}
