package ru.bolnik.spring.rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.bolnik.spring.rest.configuration.MyConfig;
import ru.bolnik.spring.rest.entity.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication comm = context.getBean(Communication.class);

//        List<Employee> allEmployees = comm.getAllEmployees();
//        for (Employee employee : allEmployees) {
//            System.out.println(employee);

//        Employee employee = comm.getEmployee(11);
//        System.out.println(employee);

//        Employee employee = new Employee("Sveta", "Sokolova", "HR", 200);
//        employee.setId(14);
//        comm.saveEmployee(employee);


        comm.deleteEmployee(123);

    }
}
