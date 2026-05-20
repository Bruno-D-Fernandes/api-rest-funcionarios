package edu.apiFuncionarios.dao;

import edu.apiFuncionarios.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager){ this.entityManager = entityManager;}

    @Override
    public Employee save(Employee employee) {
        entityManager.merge(employee);

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) { return entityManager.find(Employee.class, id);}

    @Override
    public String deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

        return ("removed: \n" + employee);
    }
}
