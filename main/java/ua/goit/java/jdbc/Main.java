package ua.goit.java.jdbc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.controllers.EmployeeController;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

        System.out.println("test");
    }

    private void start() {
        employeeController.createEmployee();
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
