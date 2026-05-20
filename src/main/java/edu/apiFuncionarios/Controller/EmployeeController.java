package edu.apiFuncionarios.Controller;

import edu.apiFuncionarios.entity.Employee;
import edu.apiFuncionarios.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;
    private JsonMapper jsonMapper;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl, JsonMapper jsonMapper) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.jsonMapper = jsonMapper;
    }

    // String mesmo?
    @PostMapping
    public String create(@RequestBody Employee employee){
        employee.setId(0);
        employeeServiceImpl.save(employee);
        return "Employee criado com sucesso";
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeServiceImpl.save(employee);
    }

    @PatchMapping("/{employeeId}")
    public Employee patch(@PathVariable int employeeId,
                          @RequestBody Map<String, Object> pathPayLoad){

        Employee tempEmployee = employeeServiceImpl.getById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee não encontrado");
        }

        if(pathPayLoad.containsKey("id")){
            throw new RuntimeException("Id não é permitido no body de patch requests");
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, pathPayLoad);

        employeeServiceImpl.save(patchedEmployee);

        return patchedEmployee;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id){
        return employeeServiceImpl.getById(id);
    }

}
