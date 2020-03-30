package com.springboot.tool.util;

import com.springboot.tool.page.domain.Page;
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
    private Integer page;
    @ApiModelProperty(value = "行数")
    private Integer row;
    @ApiModelProperty(value = "总页数")
    private Integer allPages;
    @ApiModelProperty(value = "总行数")
    private Integer allRows;

    public GridPage() {
}
    public GridPage(Page searchVo) {
        this.page=searchVo.getPage();
        this.row=searchVo.getRows();
        this.allPages=searchVo.getTotalPage();
        this.allRows=searchVo.getPageCount();
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getAllRows() {
        return allRows;
    }

    public void setAllRows(Integer allRows) {
        this.allRows = allRows;
    }
}
