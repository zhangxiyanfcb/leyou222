package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-07 20:10
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer rows, Integer page, String sortBy, Boolean desc, String key) {
        //分页--分页助手的使用
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(Brand.class);
        if(StringUtils.isNotBlank(key)){
            Example.Criteria criteria = example.createCriteria();
            criteria.orLike("name","%"+key+"%").orEqualTo("letter",key);
        }
        //排序
        if(StringUtils.isNotBlank(sortBy)){
            String sortBycouse=sortBy +(desc ? " DESC" : " ASC");
            example.setOrderByClause(sortBycouse);
        }
        //查询
        List<Brand> list = brandMapper.selectByExample(example);  //查询结果集
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.BRAND_NOT_FOND);
        }

        PageInfo<Brand> info = new PageInfo<>(list);//pageinfo是查询结果集的封装类，属于pagehelper的封装

        return  new PageResult<>(info.getTotal(),list);
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增品牌
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if(count !=1){
            throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
        }

        //新增中间表
        for (Long cid : cids) {
            int i = brandMapper.insertCategoryBrand(cid, brand.getId());
            if(i != 1){
                throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
            }
        }
    }
}
