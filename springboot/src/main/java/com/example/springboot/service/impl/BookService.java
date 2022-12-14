package com.example.springboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Category;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BookService implements IBookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.list(); //不安全，但暂时先这样
    }

    @Override
    public PageInfo<Book> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        //自关联查询
        return new PageInfo<>(bookMapper.listByCondition(baseRequest));
    }

    @Override
    public void save(Book obj) {
        obj.setCategory(category(obj.getCategories()));
        bookMapper.save(obj);
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public void update(Book obj) {
        obj.setCategory(category(obj.getCategories()));
        bookMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        bookMapper.deleteById(id);
    }

    private String category(List<String> categories){
        StringBuilder sb=new StringBuilder();
        if(CollUtil.isNotEmpty(categories)){
            categories.forEach(v->sb.append(v).append(">"));
            return sb.substring(0,sb.lastIndexOf(">"));
        }
        return sb.toString();
    }

}
