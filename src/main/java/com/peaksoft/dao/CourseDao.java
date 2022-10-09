package com.peaksoft.dao;

import com.peaksoft.entity.Course;
import com.peaksoft.util.Util;
import org.hibernate.Session;

import java.util.List;

public class CourseDao implements Dao{
    @Override
    public Object getById(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Course course = (Course) session.get(Course.class, id);
        session.getTransaction().commit();
        session.close();
        return course;
    }

    @Override
    public List<?> getAll() {
        List<Course> courses;
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        courses =  session.createQuery("from Course").list();
        session.getTransaction().commit();
        session.close();
        return courses;
    }

    @Override
    public void update(int id, Object newObject) {
        Course newCourse = (Course) newObject;
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Course course  = (Course) session.get(Course.class, id);
        course.setName(newCourse.getName());
        course.setDuration(newCourse.getDuration());
        if (newCourse.getUser() != null){
            course.setUser(newCourse.getUser());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Course course = (Course) session.get(Course.class, id);
        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }
}
