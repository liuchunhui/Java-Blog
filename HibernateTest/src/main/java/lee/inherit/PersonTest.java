package lee.inherit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.huihui.app.domain.inherit.Customer;
import org.huihui.app.domain.inherit.Employee;
import org.huihui.app.domain.inherit.Manager;
import org.huihui.app.domain.inherit.Person;

import javax.persistence.Column;

/**
 * Created by huihui on 14-11-9.
 */
public class PersonTest {

    public static void main(String[] args) {
        // --------------实例化Configration----------------------
        Configuration conf = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(conf.getProperties()).buildServiceRegistry();
        //-------------------END----------------------------------


        // 以Configuration实例创建SessionFactory实例
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        // 创建Session
        Session sess = sf.openSession();
        // 开始事务
        Transaction tx = sess.beginTransaction();

        Person person = new Person();
        person.setName("小普");
        person.setGender('男');
        person.getAddress().setCountry("中国");
        person.getAddress().setDetail("天河");
        person.getAddress().setZip("434333");

        sess.save(person);

        Manager manager = new Manager();
        manager.setName("Tom");
        manager.setGender('男');
        manager.getAddress().setCountry("美国");
        manager.getAddress().setDetail("纽约");
        manager.getAddress().setZip("100100");
        manager.setSalary(8400);
        manager.setTitle("项目经理");
        manager.setDepartment("研发部");

        Employee employee = new Employee();
        employee.setName("老朱");
        employee.setGender('男');
        employee.getAddress().setCountry("中国");
        employee.getAddress().setDetail("山东");
        employee.getAddress().setZip("276400");
        employee.setSalary(4500);
        employee.setTitle("项目组长");

        manager.getEmployees().add(employee);
        employee.setManager(manager);

        sess.save(employee);
        sess.save(manager);

        Customer customer = new Customer();
        customer.setName("小美");
        customer.setGender('女');
        customer.getAddress().setCountry("中国");
        customer.getAddress().setDetail("沂水");
        customer.getAddress().setZip("276400");
        customer.setComment("喜欢购物");
        customer.setEmployee(employee);

        sess.save(customer);

        //  提交事务
        tx.commit();
        // 关闭Session
        sess.close();

        sf.close();

    }

}
