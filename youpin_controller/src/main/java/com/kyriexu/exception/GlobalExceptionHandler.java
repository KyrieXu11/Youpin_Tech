package com.kyriexu.exception;

import com.kyriexu.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author KyrieXu
 * @since 2020/7/28 11:39
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public RespBean<Object> handlerException(GlobalException e){
        return RespBean.ERROR(e.getMsg());
    }
}
