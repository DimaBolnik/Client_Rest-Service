package ru.bolnik.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.bolnik.spring.rest.entity.Employee;

import java.util.List;

@Component
public class Communication {

    private final RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> employees = responseEntity.getBody();
        return employees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New Employee: " + responseEntity.getBody());
        }
        else {
            restTemplate.put(URL,employee);
            System.out.println("Employee ID:"+ id + " Updated!!");
        }
    }

    public ResponseEntity<String> deleteEmployee(int id) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.DELETE,
                null,
                String.class
        );

        return responseEntity;
    }
}
