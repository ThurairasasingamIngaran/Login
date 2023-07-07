package com.example.RegistationLogin.Services;

import com.example.RegistationLogin.request.EmployeeRequest;
import com.example.RegistationLogin.request.LoginRequest;
import com.example.RegistationLogin.response.LoginResponse;
import com.example.RegistationLogin.response.SignInResponse;

public interface EmployeeServices {

  public SignInResponse addEmployee(EmployeeRequest employeeRequest);

  public LoginResponse loginEmployee(LoginRequest loginRequest);
  
  boolean existsByEmail(String email);
}
