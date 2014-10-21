package com.huihui.dao;

import com.huihui.model.Article;

/**
 * Created by huihui on 14-10-21.
 */
public interface ArticleDao {

    /**
     * 通过博客文章的id来查找文章
     * @param id 博客文章的id
     * @return Article对象
     */
    public Article get(Integer id);

    /**
     * 保存博客文章，并返回保存文章的id
     * @param article
     * @return id  文章id
     */
    public Integer save(Article article);

    /**
     * 根据博客文章的id删除数据库的文章
     * @param id
     */
    public void delete(Integer id);

    /**
     * 更新文章，如果文章存在数据库则更新否则重新保存
     * @param article
     */
    public void saveOrUpdate(Article article);

    /**
     * 根据文章的标题查找博客文章（模糊查询待定）
     * @param title
     * @return
     */
    public Article findBy(String title);

}
