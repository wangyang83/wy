package com.springboot.service;

import com.springboot.domain.entity.Order;
import com.springboot.domain.search.OrderSearch;
import com.springboot.tool.util.GridPage;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/1 10:06
 */
public interface OrderService {

    /**
     * 查询订单信息
     * @param orderSearch
     * @return
     */
    GridPage<Order> selectOrder(OrderSearch orderSearch);
}
