package edu.apiFuncionarios.service;

import edu.apiFuncionarios.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // create
    Employee save(Employee employee);

    // read
    List<Employee> getAll();
    Employee getById(int id);

    // delete
    String deleteById(int id);

}
