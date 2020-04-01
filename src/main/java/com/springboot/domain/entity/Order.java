package com.springboot.domain.entity;

import com.springboot.tool.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/4/1 9:33
 */
@ApiModel(value = "订单表",parent = BaseDomain.class)
public class Order extends BaseDomain{
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    @ApiModelProperty(value = "商品总金额")
    private String goodsMoney;
    @ApiModelProperty(value = "收货方式")
    private String deliverType;
    @ApiModelProperty(value = "运费")
    private String deliverMoney;
    @ApiModelProperty(value = "订单总金额")
    private String totalMoney;
    @ApiModelProperty(value = "实际订单总金额")
    private String realTotalMoney;
    @ApiModelProperty(value = "支付来源")
    private String payType;



    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(String goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public String getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(String deliverType) {
        this.deliverType = deliverType;
    }

    public String getDeliverMoney() {
        return deliverMoney;
    }

    public void setDeliverMoney(String deliverMoney) {
        this.deliverMoney = deliverMoney;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRealTotalMoney() {
        return realTotalMoney;
    }

    public void setRealTotalMoney(String realTotalMoney) {
        this.realTotalMoney = realTotalMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
