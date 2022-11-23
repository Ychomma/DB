package com.example.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.springboot.common.Result;
import com.example.springboot.controller.request.CategoryPageRequest;
import com.example.springboot.entity.Category;
import com.example.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @PostMapping("/save")
    public Result save(@RequestBody Category obj) {
        categoryService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Category obj) {
        obj.setUpdatetime(LocalDate.now());
        categoryService.update(obj);
        return Result.success();
    }

    //删
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    //查
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category obj = categoryService.getById(id);
        return Result.success(obj);
    }

    //查询所有用户
    @GetMapping("/list")
    public Result list() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    //分页模糊查询：这里不能传入BaseRequest，否则收不到CategoryPageRequest的参数
    @GetMapping("/page")
    public Result page(CategoryPageRequest pageRequest) {
        return Result.success(categoryService.page(pageRequest));
    }
    @GetMapping("/tree")
    public Result tree(){
        List<Category>list=categoryService.list();
        return Result.success(createTree(null,list));
    }

    private List<Category> createTree(Integer pid, List<Category> categories){
        List<Category> treeList=new ArrayList<>();
        for(Category category:categories){
            if(pid==null){
                if(category.getPid()==null){
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(),categories));
                }

            }else{
                if(pid.equals(category.getPid())){
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(),categories));
                }
            }
            if(CollUtil.isEmpty(category.getChildren())){
                category.setChildren(null);
            }
        }
        return treeList;
    }


}
