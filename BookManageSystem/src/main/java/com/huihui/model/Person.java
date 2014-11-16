package com.huihui.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huihui on 14-11-15.
 */
@Entity
@Table(name = "persons_table")
public class Person {

    @Id @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 借书人号
     */
    @Column(name = "person_number")
    private String number;

    /**
     * 借书人姓名
     */
    @Column(name = "person_name")
    private String name;

    /**
     * 借书人学院
     */
    @Column(name = "person_college")
    private String college;

    /**
     * 借书人专业
     */
    @Column(name = "person_magor")
    private String major;

    // 指定mappedBy属性,表明该Person实体不控制关联关系表
   @OneToMany(targetEntity = Book.class)
   @JoinTable(name = "book_person",
           joinColumns = @JoinColumn(name = "person_id",
                   referencedColumnName = "person_id",
                   unique = true),
           inverseJoinColumns = @JoinColumn(name = "book_id",
                   referencedColumnName = "book_id")
   )
   private Set<Book> books = new HashSet<Book>();

    // 构造函数
    public Person() { }
    public Person(String number,String name,String college,String major) {
        this.number = number;
        this.name = name;
        this.college = college;
        this.major = major;
    }
    // get/set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
