package lee;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.huihui.app.domain.Person;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by huihui on 14-11-3.
 */
public class PersonManaget {
    public static void main(String[] args) throws Exception{

//        // ---查找文件的路径
//        File f = new File("src/main/java/lee/testImage.png");
//        // ---输出当前路径
//        System.out.println(f.getAbsolutePath());
//
//        System.out.println(f.exists());


        // 实例化Configuration
        Configuration conf = new Configuration().configure();


        // 创建SchemaExport对象
        SchemaExport se = new SchemaExport(conf);
        // 设置输出格式良好的SQL脚本
           se.setFormat(true)
            // 设置保存SQL脚本的文件名
            .setOutputFile("new.sql")
            // 输出SQL脚本，并执行SQL脚本
            .create(true,true);


        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(conf.getProperties()).buildServiceRegistry();
        // 以Configuration实例创建SessionFactory实例
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();

        // 创建Person对象
        Person person = new Person();
        // 为Person对象设置属性
        person.setName("虐汤前辈");
//        File file = new File("src/main/resources/images/testImage.png");
//        byte[] content = new byte[(int)file.length()];
//        new FileInputStream(file).read(content);
//        person.setPic(content);
        person.getSchools().add("小学");
        person.getSchools().add("中学");

        person.setBirth(new Date());

        person.getAddress().add("山东淄博");
        person.getAddress().add("山东临沂");
        person.getAddress().add("北京海淀");

        person.getScores().put("英语", new Float(85));
        person.getScores().put("日语", new Float(91));



        // 保存Person对象
        sess.save(person);
        //提交事务
        tx.commit();
        //关闭Session
        sess.close();
        sf.close();
    }
}
