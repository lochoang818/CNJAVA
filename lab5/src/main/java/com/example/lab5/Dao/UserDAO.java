package com.example.lab5.Dao;

import com.example.lab5.HibernateUtils;
import com.example.lab5.Model.User;
import com.example.lab5.Repository.Repository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDAO implements Repository<User> {
    @Override
    public User add(User a) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(a);
            session.getTransaction().commit();

        }
        catch (Exception e){
            System.out.println(e);

        }
        return a;
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query qr = session.createQuery("from User");
            List<User> users = qr.getResultList();
            session.getTransaction().commit();
            return users;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }
    public boolean checkLogin(String userName, String password){
        List<User> users = getAll();
        for(User u : users){
            if(u.getuserName().equals(userName) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
