package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.mapper.SpecificationMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
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
    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> querySpecByCid(Long cid){
        SpecGroup spec = new SpecGroup();
        spec.setCid(cid);

        List<SpecGroup> list = specificationMapper.select(spec);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.SPEC_NOT_FOND);
        }
        return  list;
    }

    public List<SpecParam> querySpecParamByGid(Long gid){
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        List<SpecParam> list = specParamMapper.select(param);

        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOND);
        }

        return  list;

    }
}
