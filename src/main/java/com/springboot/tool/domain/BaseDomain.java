package com.springboot.tool.domain;

import com.springboot.tool.config.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 王阳
 * @date 2020/3/25 16:44
 */
@ApiModel(value="所有实体类的父类")
@MappedSuperclass
public class BaseDomain implements  Serializable{
    private static final long serialVersionUID = -7481070909568863993L;

    @Id
    @ApiModelProperty(value = "id")
    private Long id;

    @CreatedBy
    @Column(name = "createDate")
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @CreatedBy
    @Column(name = "createUser")
    @ApiModelProperty(value = "创建人")
    private String createUser;

    @LastModifiedDate
    @Column(name = "UpdateDate")
    @ApiModelProperty(value = "更新日期")
    private Date UpdateDate;

    @LastModifiedBy
    @Column(name = "updateUser")
    @ApiModelProperty(value = "更新人")
    private String updateUser;

    @LastModifiedDate
    @Column(name = "deleteDate")
    @ApiModelProperty(value = "删除日期")
    private Date deleteDate;

    @LastModifiedBy
    @Column(name = "deleteUser")
    @ApiModelProperty(value = "删除人")
    private String deleteUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }
    public void validate() throws BaseException {
    }
}
