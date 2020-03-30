package com.springboot.tool.util;

/**
 * @author 王阳
 * @date 2020/3/27 9:43
 */
public enum ResultUtil {

    success(200), error(400),sessionTimeOut(-100),sessionLoginOther(-200);

    private Integer result;

    private ResultUtil(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
