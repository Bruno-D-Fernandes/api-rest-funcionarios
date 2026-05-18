package edu.apiFuncionarios.Controller;

import edu.apiFuncionarios.dao.EmployeeDAO;
import edu.apiFuncionarios.dao.EmployeeDAOimpl;
import edu.apiFuncionarios.entity.Employee;
import edu.apiFuncionarios.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    // String mesmo?
    @PostMapping
    // toda modificação recebe Transactional, estudar melhor
    @Transactional
    public String create(@RequestBody Employee employee){
        employeeService.create(employee);
        return "Employee criado com sucesso";
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }

}
