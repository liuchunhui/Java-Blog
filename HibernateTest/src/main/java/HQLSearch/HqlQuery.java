package HQLSearch;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.huihui.app.domain.inherit.Person;

import java.util.List;

/**
 * Created by huihui on 14-11-9.
 */
public class HqlQuery {
    public static void main(String[] args) {
        HqlQuery mgr = new HqlQuery();
        // 调用第一个方法
        mgr.findPersons();
    }

    // 第一个查询方法
     private void findPersons() {

         // 获得Hibernate Session
         Session sess = HIbernateUtil.currentSession();
         // 开始事务
         Transaction tx = sess.beginTransaction();
         // 以HQL语句创建Quary对象
         List p1 = sess.createQuery("select distinct p from  Person p "
                 + "join p.name where p.name = :eventName")
                 // 执行setName()方法为HQL语句的参数赋值
         .setString("eventName","老朱")
                 // Quary调用list()方法获取查询的全部实例
         .list();

         // 遍历查询的全部结果
         for (Object ele: p1 ) {
             Person p = (Person)ele;
             System.out.println(p.getAddress().getCountry());
         }

         // 提交事务
         tx.commit();
         HIbernateUtil.closeSession();
     }

}
