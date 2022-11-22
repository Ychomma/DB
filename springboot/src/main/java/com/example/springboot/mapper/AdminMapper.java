package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    //查出user中的所有数据（也可以在xml中进行查询）
//    @Select("select * from user")
    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void updateById(Admin user);

    void deleteById(Integer id);

    Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int updatePassword(PasswordRequest request);

    Admin getByUsername(String username);
}
//这个接口就是用来操作数据库的