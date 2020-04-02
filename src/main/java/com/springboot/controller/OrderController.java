package com.springboot.controller;

import com.springboot.domain.entity.Order;
import com.springboot.domain.search.OrderSearch;
import com.springboot.service.OrderService;
import com.springboot.tool.config.BaseException;
import com.springboot.tool.util.BaseResult;
import com.springboot.tool.util.GridPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王阳
 * @date 2020/4/1 10:00
 */
@Api(value = "查询订单信息")
@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "查询订单信息")
    @RequestMapping(value = "selectOrder",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<GridPage<Order>> selectOrder(OrderSearch orderSearch){
        BaseResult<GridPage<Order>> result = new BaseResult<>();
        try{
            result.setSuccessWithResult(orderService.selectOrder(orderSearch));
        }catch (BaseException e){
            e.getErrorMsg();
        }catch (Exception e){
            throw new BaseException("查询订单执行异常");
        }
        return result;
    }

}
