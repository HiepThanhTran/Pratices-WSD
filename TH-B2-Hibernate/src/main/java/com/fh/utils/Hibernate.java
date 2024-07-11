package com.fh.utils;

import com.fh.pojo.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate {
    @Getter
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.JAKARTA_JDBC_USER, "root");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "Admin@123");
        props.put(Environment.SHOW_SQL, true);
        configuration.setProperties(props);

        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Comment.class);
        configuration.addAnnotatedClass(OrderDetail.class);
        configuration.addAnnotatedClass(ProdTag.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(SaleOrder.class);
        configuration.addAnnotatedClass(Tag.class);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
