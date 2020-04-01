package com.springboot.mapper;

import com.springboot.domain.entity.Order;
import com.springboot.domain.search.OrderSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/1 10:07
 */
@Mapper
public interface OrderMapper {
    /**
     * 查询订单信息
     * @param orderSearch
     * @return
     */
    List<Order> selectOrder(OrderSearch orderSearch);
}
