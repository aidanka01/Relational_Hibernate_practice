package com.peaksoft.dao;

import com.peaksoft.entity.SocialMedia;
import com.peaksoft.entity.User;
import com.peaksoft.util.Util;
import org.hibernate.Session;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaDao  implements Dao {
    @Override
    public Object getById(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        SocialMedia socialMedia = (SocialMedia) session.get(SocialMedia.class, id);
        session.getTransaction().commit();
        session.close();
        return socialMedia;
    }

    @Override
    public List<?> getAll() {
        List<SocialMedia> socialMediaList = new ArrayList<>();
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        SocialMedia socialMedia = (SocialMedia) session.createQuery("from SocialMedia");
        socialMediaList.add(socialMedia);
        session.getTransaction().commit();
        session.close();
        return socialMediaList;
    }

    @Override
    public void update(int id, Object newObject) {
        SocialMedia newSocialMedia = (SocialMedia) newObject;
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        SocialMedia socialMedia = (SocialMedia) session.get(SocialMedia.class, id);

        socialMedia.setName(newSocialMedia.getName());
        socialMedia.setUserList(newSocialMedia.getUserList());

        session.save(socialMedia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from SocialMedia where id = :id").setParameter("id", id);
        session.getTransaction().commit();
        session.close();
    }
}




