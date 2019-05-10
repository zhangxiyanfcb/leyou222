package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-07 20:11
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    /**
     * 分页查询品牌
     * @param rows
     * @param page
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "rows",defaultValue ="5" ) Integer rows,
            @RequestParam(value = "page",defaultValue ="1" ) Integer page,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc,
            @RequestParam(value = "key",required = false) String key
    ){
        PageResult<Brand> result= brandService.queryBrandByPage(rows,page,sortBy,desc,key);
        return  ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        brandService.saveBrand(brand,cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
