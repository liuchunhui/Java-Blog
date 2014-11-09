package org.huihui.app.domain.inherit;

import javax.persistence.*;

/**
 * Created by huihui on 14-11-8.
 */
@Entity
@DiscriminatorValue("顾客")
@Table(name = "customer_inf")
public class Customer extends Person{

    private String comment;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id",
            referencedColumnName = "person_id",nullable = true)
    private Employee employee;

    // 构造方法
    public Customer() {

    }
    public Customer(String comment) {
        this.comment = comment;

    }

    // get/set方法

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
