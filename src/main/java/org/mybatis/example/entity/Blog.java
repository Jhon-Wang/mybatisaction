package org.mybatis.example.entity;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description:
 * @date 2018/8/3
 */

public class Blog {

    private int id;

    private String content;

    private int authCode;

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

    public int getAuthCode() {
        return authCode;
    }

    public void setAuthCode(int authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        String string = "{ id = " + id + " content = " + content + " authCode = " + authCode + " } ";
        return string;
    }
}
