package com.huihui.dao.impl;

import com.huihui.dao.ArticleDao;
import com.huihui.model.Article;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by huihui on 14-10-21.
 */
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

    /**
     * 通过博客文章的id来查找文章
     * @param id 博客文章的id
     * @return Article对象
     */
    @Override
    public Article get(Integer id) {
        return getHibernateTemplate().get(Article.class,id);
    }

    /**
     * 保存博客文章，并返回保存文章的id
     * @param article
     * @return id  文章id
     */
    @Override
    public Integer save(Article article) {
        return (Integer)getHibernateTemplate().save(article);
    }

    /**
     * 根据博客文章的id删除数据库的文章
     * @param id
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * 更新文章，如果文章存在数据库则更新否则重新保存
     * @param article
     */
    public void saveOrUpdate(Article article) {
        getHibernateTemplate().saveOrUpdate(article);
    }

    /**
     * 根据文章的标题查找博客文章（模糊查询待定）
     * @param title
     * @return
     */
    @Override
    public Article findBy(String title) {
        List<Article> articles = (List<Article>) getHibernateTemplate().find("from Article as a where a.title=?",title);

        if (articles.size() == 0) {
            System.out.println(title + "NullPointerException");
            return null;
        }else {
            return articles.get(0);
        }
    }
}
