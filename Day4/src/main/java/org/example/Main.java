package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.*;
interface UserNameGenerator
{
    void generate(String firstName,String lastName,LocalDate dob,int id);
}
class Employee
{
    String firstName;
    String lastName;
    int id;
    LocalDate dob;
    String dept;
    Double salary;

    public Employee(String firstName, String lastName, int id, LocalDate dob, String dept, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dob = dob;
        this.dept = dept;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class User
{
    int id;
    String userName;
    String password;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        List<Employee> emplist= Arrays.asList(
                new Employee("jyothi","kulkarni",1,LocalDate.of(1997,6,27),"IT",12345.00),
                new Employee("shantala","kulkarni",2,LocalDate.of(1994,9,20),"IT",12345.00),
                new Employee("narayan","kulkarni",3,LocalDate.of(1994,2,20),"IT",12345.00)
        );
        List<User> userList=Arrays.asList(
                new User(1,"jk","jk123"),
                new User(2,"sk","sk123"),
                new User(3,"nk","nk12345")
        );
        Consumer<Employee> emp=(emp1)->System.out.println(emp1);
        emp.accept(new Employee("jyothi","kulkarni",1,LocalDate.of(1997,6,27),"IT",12345.00));
        Predicate<Employee> pre=(emp2)->emp2.getSalary()>2000;
        System.out.println(pre.test( new Employee("shantala","kulkarni",1,LocalDate.of(1994,9,20),"IT",12345.00)));
        BiPredicate<Employee,Integer> bipred=(emp3,intvar)->emp3.getSalary()>intvar;
        System.out.println(bipred.test(new Employee("shantala","kulkarni",1,LocalDate.of(1994,9,20),"IT",12345.00),123456));
        Supplier<String> pass=()->{
            Random rand=new Random();
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder sb = new StringBuilder(16);
            for (int i = 0; i < 16; i++) {
                sb.append(characters.charAt(rand.nextInt(62)));
            }
            return sb.toString();

        };
        System.out.println(pass.get());

        Function<Employee,User> fun=(emp5)->{
          String userName=emp5.getFirstName()+emp5.getLastName()+emp5.getDob()+ emp5.getId();
          User user=new User(emp5.getId(),userName, pass.get());
          return user;
        };
        System.out.println(fun.apply(new Employee("shantala","kulkarni",1,LocalDate.of(1994,9,20),"IT",12345.00)));
        emplist.sort((emp1,emp2)->{
            return emp1.getDob().getMonth().compareTo(emp2.getDob().getMonth());
        });
        System.out.println("\n list of sorted employees");
        System.out.println(emplist);
        ExecutorService es=Executors.newFixedThreadPool(2);
        System.out.println("\n list of employees and users using 2 threads");
        es.submit(()->System.out.println(emplist));
        es.submit(()->System.out.println(userList));
        Function<Employee,User> fun2=(emp6)->{
            User user=fun.apply(emp6);
            return user;
        };
        System.out.println("user details");
        System.out.println(fun2.apply(new Employee("shantala","kulkarni",1,LocalDate.of(1994,9,20),"IT",12345.00)));
        }
    }
