package com.huihui.model;

import java.util.Date;

/**
 * Created by huihui on 14-10-18.
 * 访问者留言的数据模型
 */
public class Message {
    /**
     * @param id
     * 访问者留言的id
     */
    private int id;

    /**
     * @param visitor
     * 访问者姓名
     */
    private String visitor;

    /**
     * @param word
     * 访问者留言
     */
    private String word;

    /**
     * @param date
     * 访问者访问时间
     */
    private Date date;

    /**
     * @param article
     * 记录关联实体的article属性
     */
    private Article article;

    public Message() { }
    public Message(int id,String visitor,String word,Date date,Article article) {
        this.id = id;
        this.visitor = visitor;
        this.word = word;
        this.date = date;
        this.article = article;
    }

    // get/set 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
