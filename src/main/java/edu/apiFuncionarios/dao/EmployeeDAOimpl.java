package edu.apiFuncionarios.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager){ this.entityManager = entityManager;}

    @Override
    public EmployeeDAO create(EmployeeDAO employee) {

        // preciso da entidade
        entityManager.persist(employee, );

        return null;
    }

    @Override
    public List<EmployeeDAO> getAll() {
        return List.of();
    }

    @Override
    public EmployeeDAO getById(int id) {
        return null;
    }

    @Override
    public EmployeeDAO updateById(int id) {
        return null;
    }

    @Override
    public EmployeeDAO deleteById(int id) {
        return null;
    }
}
