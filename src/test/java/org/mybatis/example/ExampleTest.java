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

public class ExampleTest {

    private String resource = "mybatis-config.xml";
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private BlogMapper blogMapper = null;

    @Before
    public void setup() {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            blogMapper = sqlSession.getMapper(BlogMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectBlogTest() {
        Blog blog = blogMapper.selectBlog(1);
        System.out.println(blog);
    }

    @Test
    public void selectAllTest() {
        List<Blog> blogs = blogMapper.selectAll();
        System.out.println(blogs);
    }

    @Test
    public void insertBlogTest() {

        int num = blogMapper.insertBlog("这是第二个对象", 2);
        System.out.println(num);
    }


    @After
    public void clearUp() {
        sqlSession.close();
    }


}
