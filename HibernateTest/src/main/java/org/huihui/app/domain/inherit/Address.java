package org.huihui.app.domain.inherit;

import org.hibernate.annotations.Parent;

import javax.persistence.Embedded;

/**
 * Created by huihui on 14-11-8.
 */
public class Address {

    // 定义代表该Address详细信息
    private String detail;
    // 定义代表该Address邮编信息
    private String zip;
    // 定义代表该Address国家信息
    private String country;

    // 构造函数
    public Address() {

    }
    public Address(String detail,String zip,String country) {
        this.detail = detail;
        this.zip = zip;
        this.country = country;
    }

    // get/set方法


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
