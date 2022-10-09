package com.peaksoft.dao;

import com.peaksoft.entity.User;
import com.peaksoft.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDao implements Dao{
    @Override
    public Object getById(int id) {
        Session session = Util.getSession().openSession();;
        session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<?> getAll() {
        List<User> userList;
        Session session = Util.getSession().openSession();;
        session.beginTransaction();
        userList = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    @Override
    public void update(int id, Object newObject) {
        User newUser = (User) newObject;
        Session session = Util.getSession().openSession();;
        session.beginTransaction();

        User user = (User) session.get(User.class, id);
        user.setName(newUser.getName());
        user.setLastname(newUser.getLastname());
        user.setAge(newUser.getAge());

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = Util.getSession().openSession();;
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }





}
