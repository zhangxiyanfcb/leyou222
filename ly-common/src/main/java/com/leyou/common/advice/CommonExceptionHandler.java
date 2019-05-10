package com.leyou.common.advice;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhangxiyan
 * @create 2019-04-26 15:57
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handlerException(LyException e){
        ExceptionEnum em=e.getExceptionEnum();
        //em.getMsg()的响应结果只是普通字符串，所以对响应结果进行封装
        //return  ResponseEntity.status(em.getCode()).body(em.getMsg());
          return  ResponseEntity.status(em.getCode()).body(new ExceptionResult(e.getExceptionEnum()));

    }
}
