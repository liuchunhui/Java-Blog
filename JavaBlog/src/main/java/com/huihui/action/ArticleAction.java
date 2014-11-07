package com.huihui.action;

import com.huihui.model.Article;
import com.huihui.service.ArticleService;
import com.huihui.service.impl.ArticleServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by huihui on 14-10-22.
 */
public class ArticleAction implements Action{

    private ArticleService articleService;
    private Article article;
    /**
     * @param title
     * 记录博客文章的标题
     */
    private String title;

    /**
     * @param context
     * 记录博客文章的内容
     */
    private String context;

    // get/set方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    // 处理博客文章的execute方法
    public String execute() throws Exception {

        article = new Article();

        article.setTitle(title);
        article.setContent(context);

        System.out.println(articleService);
        System.out.println("test0");

        System.out.println(articleService.saveArticle(article));

        if (false) {
            System.out.println("test2");
            return SUCCESS;
        }else {
            System.out.println("test3");
            return ERROR;
        }

    }

}
