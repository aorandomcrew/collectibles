package service;

import exeptions.EmployeeAlreadyAddedException;
import exeptions.EmployeeNotFoundExeption;
import exeptions.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final int amountOfEmployee = 10;
    private final Map<String, Employee> employees = new HashMap<>(amountOfEmployee) {
    };


    public Employee add(String firstName, String lastName) {
        Employee employeeAdd = new Employee(firstName, lastName);
        if (employees.size() > 10) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(firstName, lastName), employeeAdd);
        return employeeAdd;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeRemove = new Employee(firstName, lastName);
        if (!employees.containsKey(createKey(firstName,lastName))) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(createKey(firstName,lastName));
        return employeeRemove;
    }

    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName,lastName))) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.get(createKey(firstName,lastName));
    }
    public List<Employee> allEmployee() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    public static String createKey(String firstName, String lastName){
        return firstName + lastName;
    }
}