package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    //增
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    //改
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return Result.success();
    }

    //查
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    //查询所有用户
    @GetMapping("/list")
    public Result list() {
        List<User> users = userService.list();
        return Result.success(users);
    }

    //分页模糊查询
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(userService.page(userPageRequest));
    }
}
