import entities.Address;
import entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class TestMain {
    private static SessionFactory sessionFactory;

    public static void main(String a[])
    {
        System.out.println("Hello");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }

        EntityManager entityManager = sessionFactory.createEntityManager();

       /* Student student = new Student();
        student.setName("Aman Khullar");
        Address address1 = new Address();
        address1.setAddress("Satna");

        address1.setStudent(student);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        System.out.println("ID = " + student.getId());
        entityManager.persist(student);
        entityManager.persist(address1);
        transaction.commit();

        System.out.println("ID = " + student.getId()); */

        Student student = entityManager.find(Student.class, (long) 3);
        for(Address address : student.getAddressList())
        {
            System.out.println(address.getAddress());
        }

        /*Address address = new Address();
        address.setAddress("Bhopal");
        address.setStudent(student);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(address);
        transaction.commit(); */
        System.out.print("Aman");
        entityManager.close();
    }
}
