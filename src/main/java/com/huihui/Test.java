package com.huihui;

import com.huihui.model.Article;
import com.huihui.service.impl.ArticleServiceImpl;

/**
 * Created by huihui on 14-10-18.
 */
public class Test {

   public static void main(String[] args) {
       Article article = new Article();
       ArticleServiceImpl articleService = new ArticleServiceImpl();

       article.setTitle("静夜思");
       article.setContent("床前明月光，疑是地上霜。举头望明月，低头思故乡");

       articleService.saveArticle(article);

   }
}
