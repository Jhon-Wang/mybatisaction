package org.mybatis.example.dao;


import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {

    int insertAuthor(int authCode,String authName);

    int updateAuthor(@Param("authCode") String authCode,@Param("authName") String authName);

}
