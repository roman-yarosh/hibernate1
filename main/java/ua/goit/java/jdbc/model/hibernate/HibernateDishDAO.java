package ua.goit.java.jdbc.model.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Dish;
import ua.goit.java.jdbc.model.dao.DishDAO;

import java.util.List;

/**
 * Created by Роман on 16.07.2017.
 */
public class HibernateDishDAO implements DishDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        getSessionFactory().getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return getSessionFactory().getCurrentSession().createQuery("SELECT d FROM Dish d").list();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT d FROM Dish d WHERE d.name = :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
