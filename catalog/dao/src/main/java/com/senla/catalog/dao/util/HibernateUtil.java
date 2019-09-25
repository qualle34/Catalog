package com.senla.catalog.dao.util;

import com.senla.catalog.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class HibernateUtil {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    @Bean
    public Session getSession() {
        return getSessionFactory().openSession();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = getConfig();
        SessionFactory sessionFactory;

        try {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (HibernateException e) {
            logger.error("Create session factory error: " + e.getMessage());
            throw e;
        }
        return sessionFactory;
    }

    private Configuration getConfig() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try (InputStream propertiesFile = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(propertiesFile);

        } catch (IOException e) {
            logger.error("Properties file for hibernate not found: " + e.getMessage());
        }

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Advert.class);
        configuration.addAnnotatedClass(VipInfo.class);
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Chat.class);
        configuration.addAnnotatedClass(Comment.class);
        configuration.addAnnotatedClass(Creds.class);
        configuration.addAnnotatedClass(Message.class);
        configuration.addAnnotatedClass(Deal.class);
        configuration.addAnnotatedClass(SellerRating.class);
        configuration.addAnnotatedClass(User.class);

        return configuration;
    }
}
