package org.mybatis.example.dto;

import java.io.Serializable;
import java.util.Objects;

public class BlogWithAuthor implements Serializable {

    private String content;

    private String authName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogWithAuthor that = (BlogWithAuthor) o;
        return Objects.equals(content, that.content) &&
                Objects.equals(authName, that.authName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, authName);
    }

    @Override
    public String toString() {
        return content + " " +authName;
    }
}
