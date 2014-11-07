package lee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.huihui.app.domain.News;
import org.huihui.app.domain.Season;

/**
 * Created by huihui on 14-10-31.
 */
public class NewsManager {
    public static void main(String[] args) throws Exception{
        // --------------实例化Configration----------------------
        Configuration conf = new Configuration()
            // 调用Configuration对象的configure()方法时，Hibernate自动加载Hibernate.cfg.xml文件
            // 不带参数Configure()方法默认加载hibernate.cfg.xml
            // 如果传入abc.xml作为参数，则不再加载hibernate.cfg.xml,改为加载abc.xml
        .configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(conf.getProperties()).buildServiceRegistry();
        //-------------------END----------------------------------

//        // -----------实例化Configuration，不填加任何配置文件------------------
//        Configuration conf = new Configuration()
//            // 通过addAnnotatedClass（）方法添加持久化类
//            .addAnnotatedClass(org.huihui.app.domain.News.class)
//            // 通过setProperty设置Hibernate的链接属性
//            .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
//            .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate?useUnicode=true&amp;characterEncoding=utf8")
//            .setProperty("hibernate.connection.username", "root")
//            .setProperty("hibernate.connection.password", "0000")
//            .setProperty("hibernate.c3p0.max_size", "20")
//            .setProperty("hibernate.c3p0.min_size", "1")
//            .setProperty("hibernate.c3p0.timeout", "5000")
//            .setProperty("hibernate.c3p0.max_statements", "100")
//            .setProperty("hibernate.c3p0.idle_test_period", "3000")
//            .setProperty("hibernate.c3p0.acquire_increment", "2")
//            .setProperty("hibernate.c3p0.validate", "true")
//            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect")
//            .setProperty("hibernate.hbm2ddl.auto", "update");
//
//        // 以Configuration实例创建SessionFactory实例
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(conf.getProperties()).build();
//        //------------------END----------------------------------------

        // 以Configuration实例创建SessionFactory实例
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();

        // 创建消息对象
        News news = new News();
        // 设置消息标题和消息内容
        news.setTitle("第二条信息标题");
        news.setContent("第二条信息内容");
        news.setHappenSeanson( Season.夏季);
        // 保存消息
        sess.save(news);




//        // 测试持久化news对象，setContent内容，无需update便保存数据库
//        news.setContent("第三条消息的内容修改");

        // 用load加载，更新持久化实体
        //News n = (News)sess.load(News.class, new Integer(1));
        //System.out.println(n.getFullContent());
        //n.setTitle("第一条信息标题修改");
        //sess.flush();

//        // 删除持久化实体
//        News n = (News) sess.load(News.class,new Integer(5));
//        sess.delete(n);

        //  提交事务
        tx.commit();
        // 关闭Session
        sess.close();

//        // 将sess关闭后，news脱管，新建s，更新脱管实体
//        news.setTitle("第三条信息的标题修改");
//        Session s = sf.openSession();
//        s.update(news);

        sf.close();

    }
}