package org.mybatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.dao.BlogMapper;
import org.mybatis.example.entity.Blog;

import java.io.IOException;
import java.io.InputStream;


public class SecondCache {


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


    /**
     * 二级缓存不生效的情况
     */
    @Test
    public void withoutCommit(){
        SqlSession sqlSession1  = sqlSessionFactory.openSession(true);
        BlogMapper blogMapper1 = sqlSession1.getMapper(BlogMapper.class);

        blogMapper.selectAll();
        blogMapper1.selectAll();

    }

    /**
     * 二级缓存生效
     */
    @Test
    public void withCommit(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        BlogMapper blogMapper1 = sqlSession1.getMapper(BlogMapper.class);

        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);
        sqlSession.commit();
        blogMapper1.selectBlog(1);
    }

    @Test
    public void testCacheWithUpdate(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        BlogMapper blogMapper1 = sqlSession1.getMapper(BlogMapper.class);
        BlogMapper blogMapper2 =  sqlSession2.getMapper(BlogMapper.class);

        System.out.println("blog 数据："+blogMapper.selectBlog(1));
        sqlSession.commit();
        System.out.println("blog 数据："+blogMapper1.selectBlog(1));

        blogMapper2.insertBlog("全新博客",0);
        sqlSession2.commit();
        System.out.println("blog 数据："+blogMapper1.selectBlog(1));
    }

    @Test
    public void testCacheWithDiffNamespcae() throws  Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        BlogMapper blogMapper1 = sqlSession1.getMapper(BlogMapper.class);
        BlogMapper blogMapper2 = sqlSession2.getMapper(BlogMapper.class);

        System.out.println("blog 数据："+blogMapper.selectBlog(1));
        sqlSession.commit();
        System.out.println("blog 数据："+blogMapper1.selectBlog(1));
    }



}

