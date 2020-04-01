package com.springboot.domain.search;

import java.io.Serializable;

/**
 * @author 王阳
 * @date 2020/3/27 14:20
 */
public class UserDomain implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
