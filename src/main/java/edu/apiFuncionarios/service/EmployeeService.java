package edu.apiFuncionarios.service;

import edu.apiFuncionarios.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    void create(Employee employee);
}
