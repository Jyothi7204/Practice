package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee
{
    String firstName;
    String lastName;
    int id;
    LocalDate dob;
    String dept;
    Double salary;
    LocalDate doj;

    public Employee(String firstName, String lastName, int id, LocalDate dob, String dept, Double salary,LocalDate doj) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dob = dob;
        this.dept = dept;
        this.salary = salary;
        this.doj=doj;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public  LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", doj=" + doj +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> emplist= Arrays.asList(
                new Employee("jyothi","kulkarni",1,LocalDate.of(1997,6,27),"HR",12345.00,LocalDate.of(2023,6,27)),
                new Employee("shantala","kulkarni",1,LocalDate.of(1997,3,27),"HR",10345.00,LocalDate.of(2024,6,27)),
                new Employee("narayan","pranesh",1,LocalDate.of(1992,5,27),"HR",1235.00,LocalDate.of(2020,6,27)),
                new Employee("akshata","talur",1,LocalDate.of(1993,2,27),"ON",1234.0,LocalDate.of(2025,6,27)),
                new Employee("rohan","kulkarni",1,LocalDate.of(1997,6,27),"CS",145.00,LocalDate.of(2023,6,27)),
                new Employee("varun","katti",1,LocalDate.of(1990,6,27),"IT",1245.00,LocalDate.of(2023,6,27))
        );
        System.out.println("\n Doj is 2023");
        emplist.stream().filter(n->n.getDoj().getYear()==2023).forEach(n->System.out.println(n.firstName));
        System.out.println("\nsorted by first name who is not hr");
        emplist.stream().sorted(Comparator.comparing(Employee::getFirstName)).filter((emp)->emp.getDept()!="HR").forEach(n->System.out.println(n));
        System.out.println("\nHR department salary increamented by 10 percent");
        System.out.println(emplist.stream().filter(emp->emp.getDept()=="HR").map((emp)->emp.getSalary()+(emp.getSalary()*1.0)));
        System.out.println("Numbers");
        Stream.iterate(101,n->n+2).limit(10).forEach(n->System.out.println(n));
        System.out.println("Generating csv");
        System.out.println(emplist.stream().sorted(Comparator.comparing(Employee::getDob)).map(Employee::getFirstName).collect(Collectors.joining(",")));

    }

}