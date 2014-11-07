package org.huihui.app.domain;


import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

/**
 * Created by huihui on 14-10-31.
 */
@Entity
@Table(name = "news_inf")
public class News {

    // 消息类的标识属性
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 消息标题
    @Column(name = "new_title",length = 50)
    private String title;
    // 消息内容
    // concent不会映射到数据列
    @Transient
    private String content;

    // EnumType.STRING 保存列举值的名称
    //@Enumerated(EnumType.STRING)
    // EnumType.STRING 保存列举值的序号
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "happen_season")
    private Season happenSeanson;


    // 消息全部内容，由系统根据公式生成 不在数据库中生成
    //@Formula("(select concat(nt.title,nt.content)" + "from news_inf nt where nt.id= id)")

    // 指定@Generated的value为ALWAYS，表明该属性的值由数据库生成
    // HIbernate会在每次执行insert，update时执行select语句来查询获取该属性的值
    //@Generated(GenerationTime.ALWAYS)
    //private String fullContent;




    public News() { }

    // set，get方法


    public Season getHappenSeanson() {
        return happenSeanson;
    }

    public void setHappenSeanson(Season happenSeanson) {
        this.happenSeanson = happenSeanson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

//    public String getFullContent() {
//        return fullContent;
//    }
//
//    public void setFullContent(String fullContent) {
//        this.fullContent = fullContent;
//    }
}
