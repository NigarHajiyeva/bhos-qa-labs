package com.example.springproj3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public String createCrud(@RequestBody Employee employee) throws InterruptedException, ExecutionException {
        return employeeService.createCrud(employee);
    }

    @GetMapping("/get/{documentId}")
    public Employee createCrud(@PathVariable String documentId) throws InterruptedException, ExecutionException{
        return employeeService.getCrud(documentId);
    }
}