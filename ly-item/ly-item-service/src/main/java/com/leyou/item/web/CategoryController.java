package com.leyou.item.web;

import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-04-29 16:30
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> querycategoryListByPid(@RequestParam("pid")Long pid){
        return ResponseEntity.ok(categoryService.querycategoryListByPid(pid));
    }


}
