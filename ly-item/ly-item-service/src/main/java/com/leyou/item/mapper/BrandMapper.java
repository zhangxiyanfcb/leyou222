package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhangxiyan
 * @create 2019-05-07 20:09
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") long cid,@Param("bid") Long bid);

    //select b.* from tb_category_brand a join tb_brand b on a.brand_id=b.id where a.category_id=76
    @Select("select b.* from tb_category_brand a join tb_brand b on a.brand_id=b.id where a.category_id= #{cid}")
    List<Brand> queryByCid(@Param("cid") Long cid);


}
