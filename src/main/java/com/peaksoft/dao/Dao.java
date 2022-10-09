package com.peaksoft.dao;

import com.peaksoft.util.Util;
import org.hibernate.Session;

import java.util.List;

public interface Dao {
    default void save(Object object) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    Object getById(int id);

    List<?> getAll();

    void update(int id, Object newObject);

    void delete(int id);
}
