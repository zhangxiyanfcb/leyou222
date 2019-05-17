package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhangxiyan
 * @create 2019-04-29 16:28
 */
public interface CategoryMapper extends Mapper<Category>, IdListMapper<Category,Long> {
}
