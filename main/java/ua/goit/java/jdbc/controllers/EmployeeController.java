package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.Position;
import ua.goit.java.jdbc.model.dao.EmployeeDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 28.06.2017.
 */
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Transactional
    public void createEmployee(){
        Set<Employee> allEmployee = new HashSet<>(employeeDAO.findAll());

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setSurName("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        if (!allEmployee.contains(employee)) {
            employeeDAO.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmpoyees(){
        return getEmployeeDAO().findAll();
    }

    @Transactional
    public Employee getEmpoyeesByName(String name){
        return getEmployeeDAO().findByName(name);
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
