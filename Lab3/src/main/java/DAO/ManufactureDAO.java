package DAO;


import Model.HibernateUtils;
import Model.Manufacture;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class ManufactureDAO {
    public boolean add(Manufacture p){
        try(Session session= HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();

            session.persist(p);

            session.getTransaction().commit();
//            session.close();

        }
        catch (Exception e){
            System.out.println(e);
            return  false;
        }
        return true;
    }
    public Manufacture get(String id){
        Session session= HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Manufacture m= session.get(Manufacture.class, id);
        session.close();
        return  m;
    }
    public List<Manufacture> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query qr = session.createQuery("from Manufacture");
            List<Manufacture> manufactures = qr.getResultList();
            session.getTransaction().commit();
            return manufactures;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }
    public boolean remove(String id){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Manufacture m = session.get(Manufacture.class, id);
            session.remove(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;
    }
    public boolean remove(Manufacture p){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Manufacture m = session.get(Manufacture.class, p);
            session.remove(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;
    }
    public  boolean update(Manufacture p){
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter location: ");
        String location = sc.nextLine();
        System.out.println("Enter Employee: ");
        int employee = sc.nextInt();

        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Manufacture m = session.get(Manufacture.class, p.getId());

            m.setEmployee(employee);
            m.setLocation(location);
            m.setName(name);
//            session.merge(m);
//            System.out.println(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;

    }
    public boolean allManGreaterThan100em(){
        List<Manufacture> ms= getAll();
        for(Manufacture m : ms){
            if(m.getEmployee() <100){
                return false;
            }
        }
        return true;
    }
    public int sumEmployees(){
        List<Manufacture> ms= getAll();
        int sum=0;
        for(Manufacture m : ms){
            sum+= m.getEmployee();
        }
        return sum;
    }
    public Manufacture lastManBaseUS(){

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            String hql = "from Manufacture m where m.location = 'US'";
            Query q = session.createQuery(hql);
            List<Manufacture> m = q.getResultList();
            if (m.isEmpty()) {
                throw new InvalidOperationException("No manufacture located in US");
            }
            return m.get(m.size()-1);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
