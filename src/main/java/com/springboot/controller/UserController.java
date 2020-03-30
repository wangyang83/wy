package com.springboot.controller;

import com.springboot.domain.User;
import com.springboot.domain.UserDomain;
import com.springboot.service.UserService;
import com.springboot.tool.config.BaseException;
import com.springboot.tool.page.domain.Page;
import com.springboot.tool.util.BaseResult;
import com.springboot.tool.util.GridPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/25 15:12
 */
@RestController
@RequestMapping(value = "/User")
@Api(value = "用户登录信息")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="插入用户信息", notes="插入用户信息")
    @RequestMapping(value="/insertUser", method= RequestMethod.POST)
    @ResponseBody
    public void insertUser(User user){
        try{
            userService.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @ApiOperation(value="插入图片", notes="插入图片")
    @RequestMapping (value = "/saveimg",method= RequestMethod.POST)
    @ResponseBody
    public Object searchMember(MultipartFile file,Long id){
        try {
            InputStream ins = file.getInputStream();
            byte[] buffer=new byte[1024];
            int len=0;
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            while((len=ins.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            byte data[] = bos.toByteArray();
            User user=new User();
//            user.setId(id);
            user.setPhoto(data);
            userService.insertPhoto(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }


    @ApiOperation(value="插入用户信息", notes="插入用户信息")
    @RequestMapping(value="/selectUser", method= RequestMethod.POST)
    @ResponseBody
    public BaseResult<GridPage<User>> selectUser(UserDomain page){
        BaseResult<GridPage<User>> result = new BaseResult<>();
        try{
            GridPage<User> user = userService.selectUser(page);
            result.setSuccessWithResult(user);
        }catch (BaseException e){
            e.getErrorMsg();
            result.setErrorWithErrorMsg(e.getErrorMsg());
        }catch (Exception e){
            throw new BaseException("执行异常");
        }
        return result;
    }

}
