package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecificationMapper;
import com.leyou.item.pojo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-09 22:17
 */
@Service
public class SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;

    public List<Specification> querySpecByCid(Long cid){
        Specification spec = new Specification();
        spec.setCategoryId(cid);

        List<Specification> list = specificationMapper.select(spec);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.SPEC_NOT_FOND);
        }
        return  list;
    }
}
