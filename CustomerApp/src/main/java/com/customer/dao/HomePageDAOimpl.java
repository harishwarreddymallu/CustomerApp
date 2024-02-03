package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.customer.entity.CustomerEntity;

@Component
public class HomePageDAOimpl implements HomePageDAO {

    private SessionFactory sessionFactory;
    Session session;

    // Constructor to inject SessionFactory via dependency injection
    public HomePageDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("Session factory is inserted by IOC container in HomePageDAO!!");
    }

    // Save customer entity to the database
    @Override
    public boolean saveCustomerEntity(CustomerEntity entity) {
        System.out.println("invoked saveCustomerEntity");
        boolean isDataSaved = false;
        Transaction transaction = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();

            System.out.println("CustomerEntity entity has been saved");

            isDataSaved = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction has been rolled back: " + e.getMessage());
            }
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
        return isDataSaved;
    }

    // Retrieve all customer entities from the database
    @Override
    public List<CustomerEntity> getAllCustomerEntity() {
        System.out.println("invoked getAllCustomerEntity() in DAO");
        String hql = "from CustomerEntity";

        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery(hql);
            List<CustomerEntity> resultList = query.getResultList();
            resultList.forEach(obj -> System.out.println(obj));
            return resultList;
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
    }

    // Delete a customer entity based on the email
    @Override
    public boolean deleteCustomerEntity(String email) {
        Session session = null;
        CustomerEntity entity = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            entity = session.get(CustomerEntity.class, email);
            session.delete(entity);
            transaction.commit();
            return true;
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
    }

    // Retrieve a customer entity based on the email
    @Override
    public CustomerEntity getEntityByEmail(String email) {
        System.out.println("invoked getEntityByEmail");
        CustomerEntity entity = null;

        try {
            session = this.sessionFactory.openSession();
            entity = session.get(CustomerEntity.class, email);
            if (entity != null) {
                return entity;
            }
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
        return entity;
    }

    // Update (edit) a customer entity
    @Override
    public boolean EditCustomerEntity(CustomerEntity entity) {
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
    }

    // Retrieve a customer entity based on the provided search criteria
    @Override
    public CustomerEntity getMemberByName(String searchby, String search) {
        System.out.println("invoked getMemberByName");
        CustomerEntity entity = null;

        String hql = "from CustomerEntity where " + searchby + " = :searchParam";

        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery(hql);
            query.setParameter("searchParam", search);
            entity = (CustomerEntity) query.uniqueResult();
            System.out.println(entity);
            if (entity != null) {
                return entity;
            }
        } catch (Exception e) {
            System.out.println("Exception in searching entity by name");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
        return entity;
    }

    // Retrieve a list of customer entities based on the provided search criteria
    @Override
    public List<CustomerEntity> getSearchByCustomerEntity(String searchby, String search) {
        System.out.println("invoked getSearchByCustomerEntity() in DAO");
        String hql = "from CustomerEntity where " + searchby + " = :searchParam";

        try {
            session = this.sessionFactory.openSession();
            Query query = session.createQuery(hql);
            query.setParameter("searchParam", search);
            List<CustomerEntity> resultList = query.getResultList();
            resultList.forEach(obj -> System.out.println(obj));
            return resultList;
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Session is closed");
            }
        }
    }
}
