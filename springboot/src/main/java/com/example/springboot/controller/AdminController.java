package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        //@RequestBody会将传入的json转换成一个对象
        LoginDTO login = adminService.login(request);
        //处理异常情况：(不建议这样写)这应该是AdminService.java中处理的问题，不该带到Controller层来处理
        //-> 改用全局异常处理
        //if (login == null) {
        //    return Result.error("用户名或密码错误");
        //}
        return Result.success(login);
    }

    @PutMapping("/password")
    public Result password(@RequestBody PasswordRequest request) {
        adminService.changePass(request);
        return Result.success();
    }

    //增
    @PostMapping("/save")
    public Result save(@RequestBody Admin obj) {
        adminService.save(obj);
        return Result.success();
    }

    //改
    @PutMapping("/update")
    public Result update(@RequestBody Admin obj) {
        adminService.update(obj);
        return Result.success();
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }

    //查
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin obj = adminService.getById(id);
        return Result.success(obj);
    }

    //查询所有用户
    @GetMapping("/list")
    public Result list() {
        List<Admin> list = adminService.list();
        return Result.success(list);
    }

    //分页模糊查询：这里不能传入BaseRequest，否则收不到AdminPageRequest的参数
    @GetMapping("/page")
    public Result page(AdminPageRequest pageRequest) {
        return Result.success(adminService.page(pageRequest));
    }
}
