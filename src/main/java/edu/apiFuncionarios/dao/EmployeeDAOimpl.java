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
    public void create(Employee employee) {
        // por que não preciso da entidade?
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) { return entityManager.find(Employee.class, id);}

    @Override
    public void updateById(Employee employee) {entityManager.merge(employee);}

    @Override
    public int deleteById(int id) {
        TypedQuery query = entityManager.createQuery("DELETE FROM Employee WHERE id = :id", Employee.class);
        query.setParameter("id", id);

        return query.executeUpdate();
    }
}
