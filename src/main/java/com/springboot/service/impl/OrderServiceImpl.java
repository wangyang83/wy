package com.springboot.service.impl;

import com.springboot.domain.entity.Order;
import com.springboot.domain.search.OrderSearch;
import com.springboot.mapper.OrderMapper;
import com.springboot.service.OrderService;
import com.springboot.tool.config.BaseException;
import com.springboot.tool.util.GridPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/1 10:07
 */
@Service(value = "OrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public GridPage<Order> selectOrder(OrderSearch orderSearch) {
        GridPage<Order> gridPage = null;
        try{
            List<Order> orders = orderMapper.selectOrder(orderSearch);
            System.out.println(orderSearch.getPage());
            gridPage = new GridPage<>(orderSearch);
            gridPage.setList(orders);
        }catch (Exception e){
            throw new BaseException("查询订单信息");
        }
        return gridPage;
    }
}
