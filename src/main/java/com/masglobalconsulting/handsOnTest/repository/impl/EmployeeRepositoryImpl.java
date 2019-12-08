package com.masglobalconsulting.handsOnTest.repository.impl;

import com.masglobalconsulting.handsOnTest.entities.Employee;
import com.masglobalconsulting.handsOnTest.repository.EmployeeRepository;
import com.masglobalconsulting.handsOnTest.repository.external.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Retrofit retrofit;

    @Override
    public List<Employee> getAll() throws IOException {
        return retrofit.create(EmployeeService.class)
                .getAll()
                .execute()
                .body();
    }
}
