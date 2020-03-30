package com.springboot.tool.config;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/3/27 9:43
 */
public class BaseException extends RuntimeException {

    @ApiModelProperty(value = "错误信息")
    private String errorMsg;
    @ApiModelProperty(value = "服务器状态码")
    private Integer code;

    public BaseException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BaseException(Integer code, String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.code = code;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public Integer getCode() {
        return code;
    }
}
