package model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
