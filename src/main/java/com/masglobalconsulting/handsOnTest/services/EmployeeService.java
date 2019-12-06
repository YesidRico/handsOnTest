package com.masglobalconsulting.handsOnTest.services;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeService {
    Stream<EmployeeDTO> getAll() throws IOException;
    Optional<EmployeeDTO> findById(Integer id) throws IOException;
}
