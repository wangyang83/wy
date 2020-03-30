package com.springboot.tool.page.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/27 10:54
 */
public class Page extends SimplePage{

    private static final long serialVersionUID = -5729336980198406499L;
    @ApiModelProperty(value = "是否是第一页")
    private boolean isFirstPage = true;
    @ApiModelProperty(value = "是否是最后一页")
    private boolean isLastPage = false;
    @ApiModelProperty(value = "当前页总记录数")
    private int pageCount = 0;
    @ApiModelProperty(value = "总页数")
    private int totalPage = 0;
    @ApiModelProperty(value = "上一页页码")
    private int prePage = 1;
    @ApiModelProperty(value = "下一页页码")
    private int nextPage = 1;

    public Page(){
        super();
    }

    public Page(int page, int rows) {
        super();
        setPage(page);
        setRows(rows);
    }

    @Override
    public Page setData(List data){
        super.setData(data);
        if(data!=null && data.size()>0){
            pageCount = data.size();
            if(this.page==1){
                isFirstPage=true;
            }else{
                isFirstPage=false;
            }
            //***
            totalPage = (int)Math.ceil(totalRecord/(double)rows);
            //***
            if(page==totalPage){
                isLastPage = true;
            }else{
                isLastPage = false;
            }
            //***
            if(isFirstPage){
                prePage = 1;
            }else{
                prePage = page-1;
            }
            //***
            if(isLastPage){
                nextPage = 1;
            }else{
                nextPage = page+1;
            }
        }else{
            isLastPage = true;
        }
        return this;
    }


    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
