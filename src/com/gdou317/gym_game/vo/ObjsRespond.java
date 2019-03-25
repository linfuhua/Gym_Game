package com.gdou317.gym_game.vo;

public class ObjsRespond<T> {
    private String msg;
    private int status_code ;
    private T objs;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public T getObjs() {
        return objs;
    }

    public void setObjs(T objs) {
        this.objs = objs;
    }
}
