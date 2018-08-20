package org.mybatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.dao.BlogMapper;
import org.mybatis.example.entity.Blog;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    private String resource = "mybatis-config.xml";
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private BlogMapper blogMapper = null;

    @Before
    public void setup(){
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
            blogMapper = sqlSession.getMapper(BlogMapper.class);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void level1CacheTest(){
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);

        Blog blog1 = blogMapper.selectBlog(1);
        System.out.println(blog);
    }

    @Test
    public void level1CacheAfterUpdate(){
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);

        blogMapper.insertBlog("新的博客",1);

        Blog blog1 = blogMapper.selectBlog(1);
        System.out.println(blog1);
    }

    @Test
    public void level1CacheScope(){
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);

        try{
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            BlogMapper blogMapper = sqlSession1.getMapper(BlogMapper.class);
            blogMapper.insertBlog("新的博客",1);

        }catch (Exception o){
            o.printStackTrace();
        }

        Blog blog1 = blogMapper.selectBlog(1);
        System.out.println(blog1);


    }


    @After
    public void clearUp(){
        sqlSession.close();
    }



}
