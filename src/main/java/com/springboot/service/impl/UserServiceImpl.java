package com.springboot.service.impl;

import com.springboot.domain.User;
import com.springboot.domain.UserDomain;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.tool.config.BaseException;
import com.springboot.tool.domain.PageResult;
import com.springboot.tool.page.domain.Page;
import com.springboot.tool.util.GridPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/25 17:41
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        try{
            userMapper.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public GridPage<User> selectUser(UserDomain page) {
        GridPage<User> gridPage = new GridPage<>();
        List<User> user = null;
        try{
             user = userMapper.getUser(page);
            gridPage.setList(user);
        }catch (Exception e){
            throw new BaseException("数据库执行异常");
        }
        /*byte[] bytes1 = user.getPhoto();// 数据库查询出来的二进制;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
        try {
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File("D:\\excel-rainy", "123.jpg");// 可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return gridPage;
    }

    @Override
    public void insertPhoto(User user) {
        userMapper.insertPhoto(user);
    }

    @Override
    public PageResult findPage(PageResult pageRequest) {
        return null;
    }
}
