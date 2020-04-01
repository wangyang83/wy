package com.springboot.service;

import com.springboot.domain.User;
import com.springboot.domain.UserDomain;
import com.springboot.tool.domain.PageResult;
import com.springboot.tool.page.domain.Page;
import com.springboot.tool.util.GridPage;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/25 17:40
 */
public interface UserService {
    /**
     * 插入
     * @param user
     */
    void insertUser(User user);


    void selectUser(Long id);


    void insertPhoto(User user);

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    PageResult findPage(PageResult pageRequest);
}
