package org.mybatis.example.Dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.example.entity.Blog;

import java.util.List;

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

    List<Blog> selectAll();

    /**
     * 插入博客实体
     * @param content 内容
     * @param authCode 代码
     * @return
     */
    int insertBlog(@Param("content") String content,@Param("authCode") int authCode);
}
