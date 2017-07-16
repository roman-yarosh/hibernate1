package ua.goit.java.jdbc.model.dao;

import ua.goit.java.jdbc.model.Dish;

import java.util.List;

/**
 * Created by Роман on 16.07.2017.
 */
public interface DishDAO {

    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);
}

