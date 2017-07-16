package ua.goit.java.jdbc.model.dao;

import ua.goit.java.jdbc.model.Order;

import java.util.List;

/**
 * Created by Роман on 16.07.2017.
 */
public interface OrderDAO {

    void save(Order order);

    List<Order> findAll();
}
