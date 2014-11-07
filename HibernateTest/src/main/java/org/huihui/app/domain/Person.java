package org.huihui.app.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.*;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by huihui on 14-11-3.
 */
@Entity
@Table(name = "persons_inf")
public class Person {
    @Id @Column(name = "person_id")
//    // @TableGenerator额外生成表，记录当前刚生成记录的主键值
//    @TableGenerator(name = "newsGen",table = "NEWS_ID_GEN",
//    pkColumnName = "gen_key",valueColumnName = "gen_value",
//    pkColumnValue = "news_id")
//    // @GenaratedValue括号中的generator的值必须和@TableGenerator的name相同
//    @GeneratedValue(strategy = GenerationType.TABLE,
//    generator = "newsGen")

    // 使用@GeneticGenerator定义主键生成器
    // 该主键生成器名为fk_hilo，使用Hibernate的hilo策略
    @GenericGenerator(name = "fk_hilo",strategy = "hilo")
    @GeneratedValue(generator = "fk_hilo")
    private Integer id;

    // @Column指定属性映射的信息，指定列名和长度
    @Column(name = "person_name",length = 50)
    private String name;

    // @Lob修饰大数据类型，映射为底层的Clob列
    @Lob
    private byte[] pic;

    // 存储时间
    @Temporal(TemporalType.TIME)
    private Date birth;

    // 集合属性，保留该对象关联的学校
    @ElementCollection(targetClass = String.class)
    // 映射保存集合属性的表
    @CollectionTable(name = "school_inf", // 指定表名为school_inf
        joinColumns = @JoinColumn(name = "person_id",nullable = false))
    // 指定保存集合元素的列为school_name
    @Column(name = "school_name")
    // 映射集合元素索引的列
    @OrderColumn(name = "list_order")
    private List<String> schools = new ArrayList<String>();

    // 集合属性，保留该对象关联地址
    @ElementCollection(targetClass = String.class)
    // 映射保存集合属性表
    @CollectionTable(name = "address_inf",// 指定表名address_inf
        joinColumns = @JoinColumn(name = "person_id",nullable = false))
    // 指定集合列为address_name，nullable= false增加非空字段
    @Column(name = "address_name",nullable = false)
    private Set<String> address = new HashSet<String>();

    // 集合属性，保留对象关联的考试成绩
    @ElementCollection(targetClass = Float.class)
    // 映射保存集合属性的表
    @CollectionTable(name = "score_inf", // 指定表名为score_inf
        joinColumns = @JoinColumn(name = "person_id",nullable = false))
    @MapKeyColumn(name = "subject_name")
    // 指定Map key的类型为String类型
    @MapKeyClass(String.class)
    // 映射保存Map value的数据列
    @Column(name = "mark")
    private Map<String ,Float> scores = new HashMap<String,Float>();

    public Person() { }

    // get set方法


    public Map<String, Float> getScores() {
        return scores;
    }

    public void setScores(Map<String, Float> scores) {
        this.scores = scores;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

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

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
