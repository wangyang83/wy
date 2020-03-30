package com.springboot.tool.page.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/27 10:49
 */
public class SimplePage implements Serializable {
    private static final long serialVersionUID = 5654961117461893236L;
    @ApiModelProperty(value = "页码，默认是第一页")
    protected int page = 1;
    @ApiModelProperty(value = "每页显示的记录数，默认是10")
    protected int rows = 10;
    @ApiModelProperty(value = "总记录数")
    protected int totalRecord;
    @ApiModelProperty(value = "对应的当前页记录")
    protected List data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List getData() {
        return data;
    }


    public SimplePage setData(List data) {
        this.data = data;
        return this;
    }

}
