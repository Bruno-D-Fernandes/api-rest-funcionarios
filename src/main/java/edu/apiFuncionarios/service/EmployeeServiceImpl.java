package edu.apiFuncionarios.service;

import edu.apiFuncionarios.dao.EmployeeDAO;
import edu.apiFuncionarios.dao.EmployeeDAOimpl;
import edu.apiFuncionarios.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

}
