package com.springboot.domain.search;

import com.springboot.tool.domain.BaseDomain;
import com.springboot.tool.page.domain.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/4/1 11:03
 */
@ApiModel(value = "OrderSearch",description = "订单信息-查询",parent = Page.class)
public class OrderSearch extends Page {
    @ApiModelProperty(value = "订单号")
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
