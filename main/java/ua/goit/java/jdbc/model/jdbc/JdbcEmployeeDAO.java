package ua.goit.java.jdbc.model.jdbc;

import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.dao.EmployeeDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Роман on 28.06.2017.
 */
public class JdbcEmployeeDAO implements EmployeeDAO{

    private DataSource dataSource;

    public JdbcEmployeeDAO() throws SQLException {
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Employee load(Long id) {
        try (Connection connection = dataSource.getConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
