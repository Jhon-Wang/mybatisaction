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
import java.util.List;

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

    /**
     * 多次查询查看缓存效果
     */
    @Test
    public void level1CacheTest(){

        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);

        Blog blog1 = blogMapper.selectBlog(1);
        System.out.println(blog1);
    }

    /**
     * 更新数据库后缓存是否有效
     */
    @Test
    public void level1CacheAfterUpdate(){
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);

        blogMapper.insertBlog("新的博客",1);

        Blog blog1 = blogMapper.selectBlog(1);
        System.out.println(blog1);
    }

    /**
     * 不同会话是否共享内部缓存
     */
    @Test
    public void level1CacheScope(){
        //查询一次使得缓存生效
        List<Blog> blogs = blogMapper.selectAll();
        System.out.println(blogs);

        try{
            //新建一个回话 更新数据库
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            BlogMapper blogMapper = sqlSession1.getMapper(BlogMapper.class);
            blogMapper.insertBlog("新的博客",1);

        }catch (Exception o){
            o.printStackTrace();
        }

        //在会话1 中再次查询查看缓存是否生效
        List<Blog> blogs1 = blogMapper.selectAll();
        System.out.println(blogs1);

    }


    @After
    public void clearUp(){
        sqlSession.close();
    }



}
