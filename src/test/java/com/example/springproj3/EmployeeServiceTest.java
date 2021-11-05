package com.example.springproj3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class EmployeeServiceTest {

    @Test
    public void Insertion() throws ExecutionException, InterruptedException {

        Employee employee = new Employee("4", "Bob", "Usa", "12345666");
        EmployeeService.createCrud(employee);

        Employee received = EmployeeService.getCrud("4");

        assertEquals(employee.getEmployeeName(), received.getEmployeeName());
        assertEquals(employee.getEmployeeAddress(), received.getEmployeeAddress());
        assertEquals(employee.getEmployeeContactNumber(), received.getEmployeeContactNumber());
    }
}
