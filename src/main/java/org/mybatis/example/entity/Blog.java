package org.mybatis.example.entity;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description:
 * @date 2018/8/3
 */

public class Blog {

    private String id;

    private String content;

    private String authCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
