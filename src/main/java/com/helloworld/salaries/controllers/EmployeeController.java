package com.helloworld.salaries.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/{employeeCode}/salary/{year}")
    public void getAvgSalary(@PathVariable int employeeCode, @PathVariable int year) {

    }
}
