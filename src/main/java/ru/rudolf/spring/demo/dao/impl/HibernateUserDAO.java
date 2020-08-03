package ru.rudolf.spring.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ru.rudolf.spring.demo.dao.UserDAO;
import ru.rudolf.spring.demo.model.User;

public class HibernateUserDAO implements UserDAO {

    private final SessionFactory sessionFactory;


    public HibernateUserDAO (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List< User > getAll() {
        return currentSession().createQuery("from User", User.class).list();
    }

    @Override
    public User getOne(String email) {
        Query<User> q = currentSession().createQuery(
                "from User where email = :email", User.class);
        q.setParameter("email", email);
        return q.list().stream().findAny().orElse(null);
    }

    @Override
    public void add(User user) {
        currentSession().save(user);
    }
}
