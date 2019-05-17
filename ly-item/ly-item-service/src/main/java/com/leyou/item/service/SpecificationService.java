package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.mapper.SpecificationMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 通过cid,gid,searching查询商品详情
     * @param gid
     * @param cid
     * @param searching
     * @return
     */
    public List<SpecParam> querySpecParamList(Long gid, Long cid, Boolean searching){
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        param.setCid(cid);
        param.setSearching(searching);

        List<SpecParam> list = specParamMapper.select(param);

        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOND);
        }

        return  list;

    }

    @Transactional
    public void saveSpecGroupByCid(Long cid, String groupname) {
        SpecGroup specGroup = new SpecGroup();
        cid=specGroup.getCid();
        specGroup.setName(groupname);
        int i=specificationMapper.insert(specGroup);

        if (i != 1) {
            throw new LyException(ExceptionEnum.SPEC_NOT_FOND);
        }
    }

}
