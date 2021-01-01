package com.workspace.rentcar.controller;

import com.workspace.rentcar.service.RcCustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApi {

    private RcCustomerService rcCustomerService;

}
