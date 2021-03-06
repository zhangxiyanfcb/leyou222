package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-04-29 16:30
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> querycategoryListByPid(Long pid){
        Category t = new Category();
        t.setParentId(pid);
        List<Category> list = categoryMapper.select(t);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOND);
        }
        return list;
    }

//    public List<Category> queryCategoryByIds(List<Long> ids){
//        List<Category> list = categoryMapper.selectByIdList(ids);
//
//        if (CollectionUtils.isEmpty(list)) {
//            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOND);
//        }
//        return list;
//    }

    public List<Category> queryCateByIds(List<Long> ids){
        List<Category> list = categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOND);
        }
        return list;
    }


}
