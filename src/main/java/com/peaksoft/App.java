package com.peaksoft;

import com.peaksoft.dao.*;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Phone;
import com.peaksoft.entity.SocialMedia;
import com.peaksoft.entity.User;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        User user = new User("Aidana", "Kadyrova", 23);
        Dao userDao = new UserDao();
        userDao.save(user);

        Dao phoneDao = new PhoneDao();
        Phone phone = new Phone("Apple", 12);
        phone.setUser(user);
        phoneDao.save(phone);


        Dao courseDao = new CourseDao();
        Course course = new Course("Java", 9);
        course.setUser(user);
        courseDao.save(course);

        Course course1 = new Course("Python", 9);
        course1.setUser(user);
        courseDao.save(course1);

        Dao socialMediaDao = new SocialMediaDao();
        SocialMedia socialMedia = new SocialMedia("whatsapp");
        socialMedia.setUser(user);
        socialMediaDao.save(socialMedia);


    }
}
