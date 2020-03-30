package com.springboot.tool.util;
/**
 * @author 王阳
 * @date 2020/3/27 9:42
 */
public class BaseResult<T> {

    private Integer status;

    private String msg;

    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorWithErrorMsg(String errorMsg) {
        this.status = ResultUtil.error.getResult();
        this.msg = errorMsg;
    }

    public void setSuccessWithResult(T result) {
        this.status = ResultUtil.success.getResult();
        this.data = result;
    }
}
