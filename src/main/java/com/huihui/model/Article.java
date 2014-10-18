package com.huihui.model;

import java.util.Date;

/**
 * Created by huihui on 14-10-18.
 */
public class Article {
    /**
     * @param id
     * 记录博客文章的id
     */
    private int id;

    /**
     * @param title
     * 博客文章的标题
     */
    private String title;

    /**
     * @param content
     * 博客文章的内容
     */
    private String content;

    /**
     * @param date
     * 博客文章的时间
     */
    private Date date;

    public Article() { }
    public Article(int id,String title,String content,Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
