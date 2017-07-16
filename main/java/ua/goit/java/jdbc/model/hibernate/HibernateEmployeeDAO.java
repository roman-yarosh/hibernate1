package ua.goit.java.jdbc.model.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.dao.EmployeeDAO;

import java.util.List;

/**
 * Created by Роман on 28.06.2017.
 */
public class HibernateEmployeeDAO implements EmployeeDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional
    public Employee load(Long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("SELECT e FROM Employee e").list();
    }

    @Override
    @Transactional
    public Employee findByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e WHERE e.name = :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        getSessionFactory().getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
