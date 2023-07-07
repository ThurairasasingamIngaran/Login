package com.example.RegistationLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.RegistationLogin.Services.EmployeeServices;
import com.example.RegistationLogin.request.EmployeeRequest;
import com.example.RegistationLogin.request.LoginRequest;
import com.example.RegistationLogin.response.LoginResponse;
import com.example.RegistationLogin.response.SignInResponse;

@RestController
@CrossOrigin
public class EmployeeController {
  @Autowired
  private EmployeeServices employeeServices;

  @PostMapping(value = "/signIn")
  public ResponseEntity<?> signInEmployee(@RequestBody EmployeeRequest employeeRequest) {
	  if (employeeRequest.getEmail().isEmpty()) {
	      return ResponseEntity.ok("Your Email is Empty !");
	    } 
	  if(employeeServices.existsByEmail(employeeRequest.getEmail())) {
		  return ResponseEntity.ok("alrady exists");
	  }
    SignInResponse signInResponse=employeeServices.addEmployee(employeeRequest);
    return ResponseEntity.ok(signInResponse);
  }

  @PostMapping(value = "/login")
  public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest) {
    LoginResponse loginResponse = employeeServices.loginEmployee(loginRequest);
    return ResponseEntity.ok(loginResponse);
  }

}
