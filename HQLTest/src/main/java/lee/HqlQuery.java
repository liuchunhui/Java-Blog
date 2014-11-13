package lee;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.huihui.domain.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by huihui on 14-11-13.
 */
public class HqlQuery
{
    public static void main(String[] args)
            throws Exception
    {
        HqlQuery mgr = new HqlQuery();
        // 调用查询方法
        mgr.findPersons();
//        // 调用第二个查询方法
//        mgr.findPersonsByHappenDate();
//        // 调用第二个查询方法
//        mgr.findPersonProperty();
    }
    // 第一个查询方法
    private void findPersons()
    {
        // 获得Hibernate Session
        Session sess = HibernateUtil.currentSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();
//        // 以HQL语句创建Query对象.
//        List pl = sess.createQuery("select distinct p from Person p "
//                + "join p.myEvents where title = :eventTitle")
//                // 执行setString()方法为HQL语句的参数赋值
//                .setString("eventTitle" , "标题0")
//                        // Query调用list()方法获取查询的全部实例
//                .list();
//        // 遍历查询的全部结果
//        for(Object ele : pl)
//        {
//            Person p = (Person)ele;
//            System.out.println(p.getName());
//        }

//        // 将选择出的属性存入List对象中
//        List pl = sess.createQuery("select new list(p.id,p.name,p.age) from Person as p")
//                .list();
//        for (Object ele : pl) {
//
//            System.out.println(ele.toString());
//        }
//        // HQL查询的聚集函数
//        List count = sess.createQuery("select count(*) from Person ").list();
//        List count = sess.createQuery("select avg (p.id) from Person as p").list();

//        //  多态查询
//        // from java.lang.Object o,返回所有被持久化的对象
//        List count = sess.createQuery(" from java.lang.Object o").list();
        List count = sess.createQuery("from Person as p1 " +
                "                      where  p1.emails ").list();
        for (Object ele : count) {

            Person p = (Person)ele;
            System.out.println(p.toString() + " "+
                    " ID:" + p.getId());
        }
        System.out.println(count.size());


        // 提交事务
        tx.commit();
        HibernateUtil.closeSession();
    }
    // 第二个查询方法
    private void findPersonsByHappenDate()throws Exception
    {
        // 获得Hibernate Session对象
        Session sess = HibernateUtil.currentSession();
        Transaction tx = sess.beginTransaction();
        // 解析出Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2014-11-10");
        System.out.println("系统开始通过日期查找人" + start);
        // 通过Session的createQuery方法创建Query对象
        List pl = sess.createQuery("select distinct p from Person p "
                + "inner join p.myEvents event where event.happenDate "
                + "between :firstDate and :endDate")
                // 设置参数
                .setDate("firstDate" , start)
                .setDate("endDate" , new Date())
                        // 返回结果集
                .list();
        // 遍历结果集
        for (Object ele : pl)
        {
            Person p = (Person)ele;
            System.out.println(p.getName());
        }
        tx.commit();
        HibernateUtil.closeSession();
    }
    // 第三个查询方法：查询属性
    private void findPersonProperty()
    {
        // 获得Hibernate Session
        Session sess = HibernateUtil.currentSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();
        // 以HQL语句创建Query对象.
        List pl = sess.createQuery("select distinct p.name , p.age "
                + "from Person p join p.myEvents")
                // Query调用list()方法访问查询得到的全部属性
                .list();
        // 遍历查询的全部结果
        for (Object ele : pl)
        {
            Object[] objs = (Object[])ele;
            System.out.println(java.util.Arrays.toString(objs));
        }
        // 提交事务
        tx.commit();
        HibernateUtil.closeSession();
    }
}