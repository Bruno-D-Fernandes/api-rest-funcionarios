package edu.apiFuncionarios.dao;

import edu.apiFuncionarios.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // create

    void create(Employee employee);

    // read

    List<Employee> getAll();

    Employee getById(int id);

    // update

    void updateById(Employee employeed);

    // delete

    int deleteById(int id);

}
