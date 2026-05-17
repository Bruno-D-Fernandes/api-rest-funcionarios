package edu.apiFuncionarios.Controller;

import edu.apiFuncionarios.dao.EmployeeDAO;
import edu.apiFuncionarios.dao.EmployeeDAOimpl;
import edu.apiFuncionarios.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeDAOimpl employeeDAOimpl;

    @Autowired
    public EmployeeController(EmployeeDAOimpl employeeDAOimpl) {
        this.employeeDAOimpl = employeeDAOimpl;
    }

    // String mesmo?
    @PostMapping
    public String create(@RequestBody Employee employee){
        employeeDAOimpl.create(employee);
        return "Employee criado com sucesso";
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeDAOimpl.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(int id){
        return employeeDAOimpl.getById(id);
    }

}
