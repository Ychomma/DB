package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    //查出user中的所有数据（也可以在xml中进行查询）
//    @Select("select * from user")
    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    void save(Book obj);

    Book getById(Integer id);

    void updateById(Book obj);

    void deleteById(Integer id);

}
//这个接口就是用来操作数据库的