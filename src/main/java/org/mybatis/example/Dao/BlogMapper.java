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


    Blog selectBlog(int id);
}
