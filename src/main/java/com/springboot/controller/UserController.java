package com.springboot.controller;

import com.springboot.domain.entity.User;
import com.springboot.service.UserService;
import com.springboot.tool.config.BaseException;
import com.springboot.tool.config.ImgCompress;
import com.springboot.tool.config.ImgUtil;
import com.springboot.tool.util.BaseResult;
import com.springboot.tool.util.GridPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

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
    @RequestMapping(value="/insertUser",method= RequestMethod.POST)
    @ResponseBody
    public Object insertUser(@RequestParam MultipartFile[] file, User user){
        try{
            for (int i=0;i<file.length;i++){
                String name = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf(".") + 1);
                if(!"jpg".equals(name)||!"jpeg".equals(name)||!"png".equals(name)){
                    return "仅支持jpg、jpeg、png格式";
                }
                byte[] bytes = ImgUtil.ScaleImage(file[i].getInputStream(), 400, 400);
                String str = new String(bytes);
                if(i==0){
                    user.setPhoto(bytes);
                }
                if(i==1){
                    user.setPhoto2(bytes);
                }
            }
//            userService.insertUser(user);
//            fout.write(bytes);
//            System.out.println(getMimeType(outUrl));
            userService.insertUser(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    @ApiOperation(value="插入单张图片", notes="插入图片")
    @RequestMapping (value = "/saveimg",method= RequestMethod.POST)
    @ResponseBody
    public Object searchMember(MultipartFile file,Long id){
        try {
//            InputStream ins = file.getInputStream();
            String name = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            if(!"jpg".equals(name)||!"jpeg".equals(name)||!"png".equals(name)){
                return "仅支持jpg、jpeg、png格式";
            }
            InputStream ins  = ImgCompress.compressImage(file,"");
            byte[] buffer=new byte[1024];
            int len=0;
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            while((len=ins.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            byte data[] = bos.toByteArray();
            User user=new User();
            user.setId(id);
            user.setPhoto(data);
            userService.insertPhoto(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }


    @ApiOperation(value="查询图片", notes="插入用户信息")
    @RequestMapping(value="/selectUser", method= RequestMethod.POST)
    @ResponseBody
    public void selectUser(Long id){
        BaseResult<GridPage<User>> result = new BaseResult<>();
        try{
            userService.selectUser(id);
        }catch (BaseException e){
            e.getErrorMsg();
            result.setErrorWithErrorMsg(e.getErrorMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseException("执行异常");
        }
//        return result;
    }

}
