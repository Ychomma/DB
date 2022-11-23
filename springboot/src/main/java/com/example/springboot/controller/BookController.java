package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @PostMapping("/save")
    public Result save(@RequestBody Book obj) {
        bookService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Book obj) {
        obj.setUpdatetime(LocalDate.now());
        bookService.update(obj);
        return Result.success();
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        bookService.deleteById(id);
        return Result.success();
    }

    //查
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book obj = bookService.getById(id);
        return Result.success(obj);
    }

    //查询所有用户
    @GetMapping("/list")
    public Result list() {
        List<Book> list = bookService.list();
        return Result.success(list);
    }

    //分页模糊查询：这里不能传入BaseRequest，否则收不到BookPageRequest的参数
    @GetMapping("/page")
    public Result page(BookPageRequest pageRequest) {
        return Result.success(bookService.page(pageRequest));
    }


}
