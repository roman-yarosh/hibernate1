package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Dish;
import ua.goit.java.jdbc.model.DishCategory;
import ua.goit.java.jdbc.model.dao.DishDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 16.07.2017.
 */
public class DishController {

    private DishDAO dishDAO;

   @Transactional
    public void createDish(){
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5.0F);
        plov.setWeight(300F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.0F);
        salad.setWeight(200F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3.0F);
        potato.setWeight(100F);

        Set<Dish> dishes = new HashSet<>(getDishDAO().findAll());

        if (!dishes.contains(plov)) {
            getDishDAO().save(plov);
        }
        if (!dishes.contains(salad)) {
            getDishDAO().save(salad);
        }
        if (!dishes.contains(potato)) {
            getDishDAO().save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes(){
        return getDishDAO().findAll();
    }

    @Transactional
    public Dish getDishByName(String name){
        return getDishDAO().findByName(name);
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }
}
