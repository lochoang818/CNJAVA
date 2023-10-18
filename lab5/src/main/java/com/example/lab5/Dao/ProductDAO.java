package com.example.lab5.Dao;

import com.example.lab5.HibernateUtils;
import com.example.lab5.Model.Product;
import com.example.lab5.Model.User;
import com.example.lab5.Repository.Repository;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO implements Repository<Product> {
    @Override
    public Product add(Product a) {
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
    public List<Product> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query qr = session.createQuery("from Product ");
            List<Product> Products = qr.getResultList();
            session.getTransaction().commit();
            return Products;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }
    public void delete(int id) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();

        }
        catch (Exception e){
            System.out.println(e);

        }
    }
}
