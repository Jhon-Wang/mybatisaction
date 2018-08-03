package org.mybatis.example;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.Dao.BlogMapper;
import org.mybatis.example.entity.Blog;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description:
 * @date 2018/8/3
 */
public class Example {


    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


            SqlSession sqlSession = sqlSessionFactory.openSession();
            Blog blog = (Blog) sqlSession.selectOne("org.mybatis.example.Dao.BlogMapper.selectBlog",101);
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            blogMapper.selectBlog(101);
            sqlSession.close();

        }catch (IOException e){

        }


    }




}
