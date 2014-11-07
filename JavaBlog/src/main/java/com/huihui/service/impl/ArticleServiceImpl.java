package com.huihui.service.impl;

import com.huihui.dao.ArticleDao;
import com.huihui.dao.impl.ArticleDaoImpl;
import com.huihui.model.Article;
import com.huihui.service.ArticleService;

/**
 * Created by huihui on 14-10-21.
 */
public class ArticleServiceImpl implements ArticleService {

    ArticleDao articleDao;

    /**
     * 通过博客文章的id来查找文章
     * @param id 博客文章的id
     * @return Article对象
     */
    @Override
    public Article getArticle(Integer id) {
        return articleDao.get(id);
    }

    /**
     * 保存博客文章，并返回保存文章的id
     * @param article
     * @return id  文章id
     */
    @Override
    public Integer saveArticle(Article article){
          return articleDao.save(article);
    }

    /**
     * 根据博客文章的id删除数据库的文章
     * @param id
     */
    @Override
    public void deleteArticle(Integer id) {
        articleDao.delete(id);
    }

    /**
     * 更新文章，如果文章存在数据库则更新否则重新保存
     * @param article
     */
    @Override
    public void saveOrUpdateArticle(Article article) {
        articleDao.saveOrUpdate(article);
    }

    /**
     * 根据文章的标题查找博客文章（模糊查询待定）
     * @param title
     * @return
     */
    @Override
    public Article findByTitle(String title) {
        return articleDao.findBy(title);
    }

    // ArticleDao 的get/set方法

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
