package com.huihui.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * @param messages
     * 博客文章的评论留言
     */
    private Set<Message> messages = new HashSet<Message>();

    public Article() { }
    public Article(int id,String title,String content,Date date,Set<Message> messages) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.messages = messages;
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

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
