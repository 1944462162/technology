package com.imustacm.controller;

import com.imustacm.domain.RelationVo.DefaultResponseVo;
import com.imustacm.domain.Vo.UsersVo;
import com.imustacm.service.LoginService;
import com.imustacm.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 2020/1/3 4:20
 * Content:
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录注册")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/getAllUsers")
    public DefaultResponseVo getAllUsers(){
        List<UsersVo> usersVos = loginService.getAllUser();
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        if (usersVos != null && usersVos.size() != 0){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("users",usersVos);
            defaultResponseVo.setData(hashMap);
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("获取所有用户信息失败");
        }
        return defaultResponseVo;
    }

    @DeleteMapping("/deleteUser/{index}")
    public DefaultResponseVo deleteUser(@PathVariable("index") String index){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = loginService.DeleteUserByCode(index);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("删除用户信息失败");
        }
        return defaultResponseVo;
    }

    @PutMapping("/updateUser")
    public DefaultResponseVo updateUser(@RequestBody UsersVo usersVo){
        DefaultResponseVo defaultResponseVo = new DefaultResponseVo();
        int code = loginService.UpdateUserByCode(usersVo);
        if (code == 1){
            defaultResponseVo.setCode(200);
            defaultResponseVo.setMsg("ok");
        }
        else{
            defaultResponseVo.setCode(500);
            defaultResponseVo.setMsg("更新用户信息失败");
        }
        return defaultResponseVo;
    }
}
