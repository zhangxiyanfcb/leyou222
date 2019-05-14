package com.leyou.item.web;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-09 22:17
 */
@RequestMapping("spec")
@RestController
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;


    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecByCid(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(specificationService.querySpecByCid(cid));
    }

    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParamByGid(@RequestParam("gid") Long gid){
        return ResponseEntity.ok(specificationService.querySpecParamByGid(gid));
    }
}
