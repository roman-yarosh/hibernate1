package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.Position;
import ua.goit.java.jdbc.model.dao.EmployeeDAO;

/**
 * Created by Роман on 28.06.2017.
 */
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Transactional
    public void createEmployee(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Name1");
        employee.setSurName("Sur1");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        employeeDAO.save(employee);
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
