package ua.goit.java.jdbc.model.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Order;
import ua.goit.java.jdbc.model.dao.OrderDAO;

import java.util.List;

/**
 * Created by Роман on 16.07.2017.
 */
public class HibernateOrderDAO implements OrderDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    @Transactional
    public void save(Order order) {
        getSessionFactory().getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return getSessionFactory().getCurrentSession().createQuery("SELECT o FROM Order o").list();
    }
}
