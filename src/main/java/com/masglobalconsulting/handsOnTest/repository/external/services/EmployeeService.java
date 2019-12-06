package com.masglobalconsulting.handsOnTest.repository.external.services;

import com.masglobalconsulting.handsOnTest.entities.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface EmployeeService {

    @GET("employees")
    Call<List<Employee>> getAll();
}
