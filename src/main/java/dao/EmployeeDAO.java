package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // create
    void add(Employee employee);

    // read
    List<Employee> getAll();

    Employee getById(Long id);

    // update
    void update(Employee employee);

    // delete
    void remove(Employee employee);
}
