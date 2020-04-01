package com.springboot.mapper;

import com.springboot.domain.User;
import com.springboot.domain.UserDomain;
import com.springboot.tool.page.domain.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 王阳
 * @date 2020/3/24 17:03
 */
@Mapper
public interface UserMapper {

    Integer insertUser(User user);

    Integer insertPhoto(User user);

    List<User> getUser(UserDomain page);

    User selectUser(Long id);
}
