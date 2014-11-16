package com.huihui.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huihui on 14-11-14.
 */
@Entity
@Table(name = "books_table")
public class Book {

    /**
     * 书籍id编号
     */
    @Id @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 书籍名称
     */
    @Column(name = "book_name")
    private String name;

    /**
     * 书籍作者
     */
    @Column(name = "book_author")
    private String author;

    /**
     * 书籍价格
     */
    @Column(name = "book_price")
    private double price;

    /**
     * 书籍出版社
     */
    @Column(name = "book_press")
    private String press;

    /**
     * 书籍借出时间
     */
    @Column(name = "book_lend_time")
    private Date lendTime = new Date();

    @ManyToOne(targetEntity = Person.class)
    @JoinTable(name = "book_person",
               joinColumns = @JoinColumn(name = "book_id",
               referencedColumnName = "book_id",
               unique = true),
               inverseJoinColumns = @JoinColumn(name = "person_id",
               referencedColumnName = "person_id")
    )
    private Person person = new Person();

    // 构造方法
    public Book() { }
    public Book(String name,String author,double price,String press) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
    }

    // set/get方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }
}
