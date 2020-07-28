package com.kyriexu.controller;

import com.kyriexu.model.RespBean;
import com.kyriexu.model.User;
import com.kyriexu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/7/28 13:10
 **/
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public RespBean<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users == null ? RespBean.ERROR("没有查询到数据") : RespBean.OK(users, "");
    }

    @PostMapping("/adduser")
    public RespBean<Object> addUser(@RequestBody User user) {
        return userService.addUser(user) ? RespBean.OK("添加成功") : RespBean.ERROR("添加失败");
    }

    @PutMapping("/updateuser")
    public RespBean<Object> updateUser(@RequestBody User user) {
        return userService.updateUser(user) ? RespBean.OK("修改成功") : RespBean.ERROR("修改失败");
    }

    @DeleteMapping("/deleteuser/{username}")
    public RespBean<Object> deleteUser(@PathVariable String username) {
        return userService.deleteUser(username) ? RespBean.OK("删除成功") : RespBean.ERROR("删除失败");
    }
}
