package org.huihui.app.domain.inherit;

import javax.persistence.*;

/**
 * Created by huihui on 14-11-8.
 */
@Entity
// 定义辨别者列的列名为person_type,列类型为字符串
@DiscriminatorColumn(name = "person_type",
        discriminatorType = DiscriminatorType.STRING)
// 指定person实体对应的记录在辨别者列的值为"普通人"
@DiscriminatorValue("普通人")
@Table(name = "person_inf")
public class Person {
    // 标识属性
    @Id @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private char gender;

    // 定义该person实体组件属性Address
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "detail",column = @Column(name = "address_detail")),
            @AttributeOverride(name = "zip",column = @Column(name = "address_zip")),
            @AttributeOverride(name = "country",column = @Column(name = "address_country"))
    })
    private Address address;

    //  构造方法
    public Person() {
        address = new Address();

    }
    private Person(Integer id,String name,char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    // get/set方法


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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
