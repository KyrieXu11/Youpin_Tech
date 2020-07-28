package com.kyriexu.exception;

/**
 * @author KyrieXu
 * @since 2020/7/28 10:08
 **/
public class GlobalException extends RuntimeException {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public GlobalException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
