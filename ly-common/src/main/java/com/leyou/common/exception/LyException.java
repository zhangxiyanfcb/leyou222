package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zhangxiyan
 * @create 2019-04-28 16:05
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LyException extends  RuntimeException {

    private ExceptionEnum exceptionEnum;
}
