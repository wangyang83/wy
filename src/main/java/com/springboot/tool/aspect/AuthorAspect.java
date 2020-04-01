package com.springboot.tool.aspect;

import com.springboot.tool.domain.BaseDomain;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 王阳
 * @date 2020/4/1 9:40
 */

@Aspect
@Repository("AuthorAspect")
public class AuthorAspect {
    final static Logger logger = LoggerFactory.getLogger(AuthorAspect.class);

   /* @Before("execution(public * com.springboot.mapper.insert*(..))&&args(baseDomain,..)")
    public void login(BaseDomain baseDomain){//切点映射，命名不规定
        baseDomain.setCreateDate(new Date());
        baseDomain.setCreateUser("admin");
    }*/

}
