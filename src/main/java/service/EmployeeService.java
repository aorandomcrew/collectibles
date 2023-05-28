package service;

import exeptions.EmployeeAlreadyAddedException;
import exeptions.EmployeeNotFoundExeption;
import exeptions.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final int amountOfEmployee = 10;


    public Employee add(String name, String lastName) {
        Employee employeeAdd = new Employee(name, lastName);
        if (employees.size() > 10) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employeeAdd)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employeeAdd);
        return employeeAdd;
    }

    public Employee remove(String name, String lastName) {
        Employee employeeRemove = new Employee(name, lastName);
        if (!employees.contains(employeeRemove)) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employeeRemove);
        return employeeRemove;
    }

    public Employee find(String name, String lastName) {
        for (Employee employee : employees) {
            if (name.equals(employee.getName()) && lastName.equals(employee.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundExeption();
    }

    public List<Employee> allEmployee() {
        return Collections.unmodifiableList(employees);
    }
}
