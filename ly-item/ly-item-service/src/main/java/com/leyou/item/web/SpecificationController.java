package com.leyou.item.web;

import com.leyou.item.pojo.Specification;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Specification>> querySpecByCid(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(specificationService.querySpecByCid(cid));
    }
}
