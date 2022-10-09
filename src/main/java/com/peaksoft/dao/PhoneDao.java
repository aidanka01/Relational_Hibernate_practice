package com.peaksoft.dao;

import com.peaksoft.entity.Phone;
import com.peaksoft.util.Util;
import org.hibernate.Session;

import java.util.List;

public class PhoneDao implements Dao{
    @Override
    public Object getById(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class, id);
        session.getTransaction().commit();
        session.close();
        return phone;
    }

    @Override
    public List<?> getAll() {
        List<Phone> phones;
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        phones = session.createQuery("from Phone").list();
        session.getTransaction().commit();
        session.close();
        return phones;
    }

    @Override
    public void update(int id, Object newObject) {
        Phone newPhone = (Phone) newObject;
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class, id);

        phone.setNumber(newPhone.getNumber());
        phone.setNumber(newPhone.getNumber());

        if (newPhone.getUser() != null) {
            phone.setUser(newPhone.getUser());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Phone phone =  (Phone) session.get(Phone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
    }
}
