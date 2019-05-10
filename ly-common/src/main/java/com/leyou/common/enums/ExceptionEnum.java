package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zhangxiyan
 * @create 2019-04-28 16:07
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"商品不能为空"),
    BRAND_NOT_FOND(404,"品牌未查询到"),
    BRAND_SAVE_ERROR(500,"品牌新增失败"),
    ILLEGAL_IMAGE_TYPE(400,"图片类型不合规"),
    IMAGE_UPLOAD_ERROR(500,"图片上传失败"),
    SPEC_NOT_FOND(404,"商品分组未查询到"),
    ;
    private int code;
    private String msg;
}
