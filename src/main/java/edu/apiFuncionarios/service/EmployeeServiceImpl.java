package edu.apiFuncionarios.service;

import edu.apiFuncionarios.dao.EmployeeDAO;
import edu.apiFuncionarios.dao.EmployeeDAOimpl;
import edu.apiFuncionarios.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDAOimpl employeeDAOimpl;

    public EmployeeServiceImpl(EmployeeDAOimpl employeeDAOimpl) {
        this.employeeDAOimpl = employeeDAOimpl;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAOimpl.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAOimpl.getAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDAOimpl.getById(id);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        return employeeDAOimpl.deleteById(id);
    }
}
