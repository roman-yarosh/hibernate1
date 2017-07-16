package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Dish;
import ua.goit.java.jdbc.model.Order;
import ua.goit.java.jdbc.model.dao.DishDAO;
import ua.goit.java.jdbc.model.dao.EmployeeDAO;
import ua.goit.java.jdbc.model.dao.OrderDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 16.07.2017.
 */
public class OrderController {

    private EmployeeDAO employeeDAO;
    private DishDAO dishDAO;
    private OrderDAO orderDAO;

    public void createOrder(String waiterName, List<String> dishes, int tableNumber){

        Order order = new Order();
        order.setWaiter(employeeDAO.findByName(waiterName));
        order.setDishes(crerateDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());
        orderDAO.save(order);

    }

    private List<Dish> crerateDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes){
            result.add(dishDAO.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public void printAllOrders(){
        getAllOrders().forEach(System.out::println);
    }

    @Transactional
    public List<Order> getAllOrders(){
        return getOrderDAO().findAll();
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
