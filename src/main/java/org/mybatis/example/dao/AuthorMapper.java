package org.mybatis.example.dao;


public interface AuthorMapper {

    int insertAuthor(int authCode,String authName);

    int updateAuthor(String authCode,String authName);

}
