package org.mybatis.example.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.example.entity.Blog;

import java.util.List;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description: 数据库交互接口定义
 * @date 2018/8/3
 */
public interface BlogMapper {

    /**
     * 根据id 查询Blog
     * @param id 博客ID
     * @return 博客实体
     */
    Blog selectBlog(int id);

    /**
     * 查询所有的Blog
     * @return 所有的Blog
     */
    List<Blog> selectAll();

    /**
     * 插入博客实体
     * @param content 内容
     * @param authCode 代码
     * @return 返回修改行数
     */
    int insertBlog(@Param("content") String content,@Param("authCode") int authCode);
}
