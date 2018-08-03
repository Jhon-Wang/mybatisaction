package org.mybatis.example.Dao;

import org.mybatis.example.entity.Blog;

/**
 * Copyright © 2018 pagoda Inc.
 *
 * @author wangjunjun
 * @Description:
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
     * 插入博客实体
     * @param blog 博客
     * @return 数量
     */
    int insertBlog(Blog blog);
}
