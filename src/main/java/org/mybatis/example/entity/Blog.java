package org.mybatis.example.entity;

import java.io.Serializable;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description: 博客实体类
 * @date 2018/8/3
 */

public class Blog implements Serializable {

    private int id;

    private String content;

    private String authCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        return "{ id = " + id + " content = " + content + " authCode = " + authCode + " } ";
    }
}
