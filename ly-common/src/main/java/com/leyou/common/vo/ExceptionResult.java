package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author zhangxiyan
 * @create 2019-04-28 16:56
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private long timestamp;

    public ExceptionResult(ExceptionEnum e) {
        this.status = e.getCode();
        this.message=e.getMsg();
        this.timestamp=System.currentTimeMillis();
    }
}
