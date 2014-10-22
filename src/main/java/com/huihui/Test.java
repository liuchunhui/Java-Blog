package com.huihui;

import com.huihui.model.Article;
import com.huihui.service.ArticleService;

/**
 * Created by huihui on 14-10-18.
 */
public class Test {

   private ArticleService articleService;

   public static void main(String[] args) {
       Article article = new Article();

       article.setTitle("静夜思");
       article.setContent("床前明月光，疑是地上霜。举头望明月，低头思故乡");

       //articleService.saveArticle(article);

   }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
