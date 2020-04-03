package com.springboot.service.impl;

import com.springboot.domain.entity.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.tool.domain.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

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
    public void selectUser(Long id) {
//        GridPage<User> gridPage = new GridPage<>();
//        List<User> user = null;
//        try{
//             user = userMapper.getUser(page);
//            gridPage.setList(user);
//        }catch (Exception e){
//            throw new BaseException("数据库执行异常");
//        }
        File file =new File("D:/images");
        //如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory()) {
            file .mkdir();
        }
        User user = userMapper.selectUser(id);
        // 数据库查询出来的二进制;

        if(user.getPhoto() != null){
            byte[] bytes1 = user.getPhoto();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            try {
                BufferedImage bi1 = ImageIO.read(bais);
                // 可以是jpg,png,gif格式
                File w2 = new File("D:/images", "123457.jpg");
                // 可以是jpg,png,gif格式
                ImageIO.write(bi1, "jpg", w2);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(user.getPhoto2() != null){
            try {
                byte[] bytes2 = user.getPhoto2();
                ByteArrayInputStream bais2 = new ByteArrayInputStream(bytes2);
                BufferedImage bi2 = ImageIO.read(bais2);
                File w3 = new File("D:/cc", "123458.jpg");
                ImageIO.write(bi2, "jpg", w3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void insertPhoto(User user) {
        try{
            userMapper.insertPhoto(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public PageResult findPage(PageResult pageRequest) {
        return null;
    }
}
