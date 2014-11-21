package com.huihui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by huihui on 14-11-14.
 */
public class Test {

    public static void main(String[] args) {
//        // --------------实例化Configration----------------------
//        Configuration conf = new Configuration().configure();
//
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
//                .applySettings(conf.getProperties()).buildServiceRegistry();
//        //-------------------END----------------------------------
//
//        // 以Configuration实例创建SessionFactory实例
//        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
//        // 创建Session
//        Session sess = sf.openSession();
//        // 开始事务
//        Transaction tx = sess.beginTransaction();
//
//        //  提交事务
//        tx.commit();
//        // 关闭Session
//        sess.close();
//
//        sf.close();
//
//
    }



}
