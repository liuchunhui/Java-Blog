package org.huihui.app.domain.inherit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huihui on 14-11-8.
 */
@Entity
@DiscriminatorValue("经理")
@Table(name = "manager_inf")
public class Manager extends Person{
    // 定义该经理的成员变量
    private String title;
    // 定义该经理的成员变量
    private double salary;
    // 定义该经理的部门
    private String department;

    // 定义和该Manager保持关系的Employee类
    @OneToMany(targetEntity = Employee.class,mappedBy = "manager")
    private Set<Employee> employees = new HashSet<Employee>();

    // 构造方法
    public Manager() {

    }
    public Manager(String title,double salary,String department) {
        this.title = title;
        this.salary = salary;
        this.department = department;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
