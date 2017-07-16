package ua.goit.java.jdbc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.controllers.DishController;
import ua.goit.java.jdbc.controllers.EmployeeController;
import ua.goit.java.jdbc.controllers.OrderController;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        getEmployeeController().createEmployee();
        getDishController().createDish();

        getEmployeeController().getAllEmpoyees().forEach(System.out::println);
        getDishController().getAllDishes().forEach(System.out::println);

        System.out.println(getEmployeeController().getEmpoyeesByName("John"));
        System.out.println(getDishController().getDishByName("Plov"));

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");
        getOrderController().createOrder("John",dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Potato");
        dishes2.add("Salad");
        getOrderController().createOrder("John",dishes2, 2);

        getOrderController().printAllOrders();
        //getOrderController().getAllOrders().forEach(System.out::println);


    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    public DishController getDishController() {
        return dishController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
