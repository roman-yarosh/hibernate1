package ua.goit.java.jdbc.model.dao;

import ua.goit.java.jdbc.model.Employee;

import java.util.List;

/**
 * Created by Роман on 28.06.2017.
 */
public interface EmployeeDAO {

    Employee load(Long id);

    void save(Employee employee);

    List<Employee> findAll();
}
