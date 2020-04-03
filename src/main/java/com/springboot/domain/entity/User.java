package com.springboot.domain.entity;

import com.springboot.tool.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王阳
 * @date 2020/3/25 16:12
 */
@ApiModel(value="Member对象",parent = BaseDomain.class)
public class User extends BaseDomain {

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户密码",required = true)
    private String password;

    @ApiModelProperty(value = "用户年龄",required = true)
    private Integer age;

    @ApiModelProperty(value = "用户等级",required = true)
    private Integer grade;


    @ApiModelProperty(value = "照片")
    private byte[] photo;

    @ApiModelProperty(value = "照片2")
    private byte[] photo2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }
}
