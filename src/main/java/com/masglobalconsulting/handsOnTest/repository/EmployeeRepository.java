package com.masglobalconsulting.handsOnTest.repository;

import com.masglobalconsulting.handsOnTest.entities.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll() throws IOException;
}
