package com.kyriexu.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:28
 **/
@Getter
@Setter
public class RespBean<T> {
    private int code;
    private T obj;
    private String msg;

    private RespBean(){}

    private RespBean(int code, T obj, String msg) {
        this.code = code;
        this.obj = obj;
        this.msg = msg;
    }

    public static <T> RespBean<T> OK(T obj,String msg){
        return new RespBean<>(200,obj,msg);
    }

    public static <T> RespBean<T> OK(int code,T obj,String msg){
        return new RespBean<>(code,obj,msg);
    }


    public static <T> RespBean<T> OK(int code,String msg){
        return new RespBean<>(code,null,msg);
    }

    public static <T> RespBean<T> OK(String msg){
        return new RespBean<>(200,null,msg);
    }

    public static <T> RespBean<T> ERROR(int code,String msg){
        return new RespBean<>(code,null,msg);
    }

    public static <T> RespBean<T> ERROR(int code,T obj,String msg){
        return new RespBean<>(code,obj,msg);
    }

    public static <T> RespBean<T> ERROR(String msg){
        return new RespBean<>(400,null,msg);
    }

    public static <T> RespBean<T> ERROR(T obj,String msg){
        return new RespBean<>(400,obj,msg);
    }
}
