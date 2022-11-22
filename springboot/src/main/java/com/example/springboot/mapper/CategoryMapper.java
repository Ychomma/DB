package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.PasswordRequest;
import com.example.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //查出user中的所有数据（也可以在xml中进行查询）
//    @Select("select * from user")
    List<Category> list();

    List<Category> listByCondition(BaseRequest baseRequest);

    void save(Category obj);

    Category getById(Integer id);

    void updateById(Category obj);

    void deleteById(Integer id);

}
//这个接口就是用来操作数据库的