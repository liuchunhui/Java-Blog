package com.huihui.service;

import com.huihui.model.Article;

/**
 * Created by huihui on 14-10-21.
 */
public interface ArticleService {
    /**
     * 通过博客文章的id来查找文章
     * @param id 博客文章的id
     * @return Article对象
     */
    public Article getArticle(Integer id);

    /**
     * 保存博客文章，并返回保存文章的id
     * @param article
     * @return id  文章id
     */
    public Integer saveArticle(Article article);

    /**
     * 根据博客文章的id删除数据库的文章
     * @param id
     */
    public void deleteArticle(Integer id);

    /**
     * 更新文章，如果文章存在数据库则更新否则重新保存
     * @param article
     */
    public void saveOrUpdateArticle(Article article);

    /**
     * 根据文章的标题查找博客文章（模糊查询待定）
     * @param title
     * @return
     */
    public Article findByTitle(String title);

}
