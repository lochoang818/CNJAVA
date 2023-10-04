package DAO;

import DAO.ManufactureDAO;
import Model.HibernateUtils;
import Model.Phone;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PhoneDAO {
    public boolean add(Phone p){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
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
    public Phone get(String id){
        Session session= HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Phone m= session.get(Phone.class, id);
        session.close();
        return  m;
    }
    public List<Phone> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query qr = session.createQuery("from Phone");
            List<Phone> phones = qr.getResultList();
            session.getTransaction().commit();
            return phones;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }
    public boolean remove(String id){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Phone m = session.get(Phone.class, id);
            session.remove(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;
    }
    public boolean remove(Phone p){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Phone m = session.get(Phone.class, p);
            session.remove(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;
    }

    public Phone highestPrice(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        String sql= "select p from Phone p where p.price = (select max(price) from Phone )";
        Query query = session.createQuery(sql);
        List<Phone> phones = query.getResultList();
        session.close();
        return  phones.get(0);
    }
    public List<Phone> getPhonesByCountry(String country) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "FROM Phone p WHERE p.country = :country ORDER BY p.price DESC";
            Query query = session.createQuery(hql, Phone.class);
            query.setParameter("country", country);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Xử lý lỗi hoặc trả về danh sách trống tùy theo trường hợp.
        }
    }
    public boolean checkPriceGreaterThan50mil(Phone p) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) FROM Phone p WHERE p.id = :id AND p.price > 500";

            Query query = session.createQuery(hql);
            query.setParameter("id", p.getId());
            Long count = (Long) query.getSingleResult();

            return count != null && count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            return false;
        }
    }
    public Phone getPhoneByCriteria(){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            String hql= " from Phone p where p.color = 'gray' and p.price>500";
            Query query = session.createQuery(hql, Phone.class);
            List<Phone> p= query.getResultList();
            if(!p.isEmpty()){
                return  p.get(0);
            }
            else{
                return  null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            return null;
        }
    }
    public  boolean update(Phone p){
        Scanner sc =new Scanner(System.in);
//    public Phone(String id, String name, String color, int price, String country, int quantity, Manufacture manufacture) {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter color: ");
        String color= sc.nextLine();
        System.out.println("Enter country: ");
        String country = sc.nextLine();
        System.out.println("Enter Price: ");
        int price = sc.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Manufacture ID: ");
        String man_id = sc.nextLine();
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Phone m = session.get(Phone.class, p.getId());
            ManufactureDAO man =new ManufactureDAO();
            m.setManufacture(man.get(man_id));
            m.setName(name);
            m.setColor(color);
            m.setCountry(country);
            m.setQuantity(quantity);
            m.setPrice(price);
            session.merge(m);
            session.getTransaction().commit();

        }
        catch (Throwable ex){
            return false;
        }
        return true;

    }
}



