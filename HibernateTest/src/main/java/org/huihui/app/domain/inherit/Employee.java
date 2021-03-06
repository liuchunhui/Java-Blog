package org.huihui.app.domain.inherit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huihui on 14-11-8.
 */
// 员工继承了person类
@Entity
// 指定Employee实体对应记录在辨别者列的值为员工
@DiscriminatorValue("员工")
@Table(name = "employee_inf")
public class Employee extends Person {

    // 定义该员工职位的成员变量
    private String title;
    // 定义该员工工资的成员变量
    private double salary;

    //  定义和该员工保持关联的Customer关联实体
    // mappedBy = "employee",一端不能控制关联关系
    @OneToMany(cascade = CascadeType.ALL,
        mappedBy = "employee",targetEntity = Customer.class)
    private Set<Customer> customers = new HashSet<Customer>();

    // 定义和该员工保持关联的Manager关联实体
    @ManyToOne(cascade = CascadeType.ALL,
    targetEntity = Manager.class)
    @JoinColumn(name = "manager_id",referencedColumnName = "person_id",nullable = true)
    private Manager manager;

    // 构造函数
    public Employee() {

    }

    public Employee(String title,double salary) {
        this.title = title;
        this.salary = salary;
    }

    // get/set方法


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
