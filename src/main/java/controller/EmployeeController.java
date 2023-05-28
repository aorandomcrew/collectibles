package controller;

import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName) {
        return employeeService.add(name, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName) {
        return employeeService.remove(name, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String name, @RequestParam("lastName") String lastName) {
        return employeeService.find(name, lastName);
    }

    @GetMapping("/listOfEmployee")
    public List<Employee> listOfEmployee() {
        return employeeService.allEmployee();
    }
}
