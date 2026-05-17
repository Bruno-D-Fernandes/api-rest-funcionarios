package edu.apiFuncionarios.dao;

import java.util.List;

public interface EmployeeDAO {

    // create

    EmployeeDAO create(EmployeeDAO employee);

    // read

    List<EmployeeDAO> getAll();

    EmployeeDAO getById(int id);

    // update

    EmployeeDAO updateById(int id);

    // delete

    EmployeeDAO deleteById(int id);

}
