package com.springboot.tool.util;

import com.springboot.tool.page.domain.Page;
import com.springboot.tool.page.domain.SimplePage;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/27 14:41
 */
public class GridPage<T> implements Serializable {
    private static final long serialVersionUID = 4567205222572435215L;
    @ApiModelProperty(value = "数据集")
    private List<T> list;
    @ApiModelProperty(value = "页码")
    private int page;
    @ApiModelProperty(value = "行数")
    private int row;
    @ApiModelProperty(value = "总页数")
    private int allPages;
    @ApiModelProperty(value = "总行数")
    private int allRows;

    public GridPage() {}

    public GridPage(Page searchVo) {
        this.page=searchVo.getPage();
        this.row=searchVo.getRows();
        this.allPages=searchVo.getTotalRecord();
        this.allRows=searchVo.getPageCount();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getAllRows() {
        return allRows;
    }

    public void setAllRows(int allRows) {
        this.allRows = allRows;
    }
}
