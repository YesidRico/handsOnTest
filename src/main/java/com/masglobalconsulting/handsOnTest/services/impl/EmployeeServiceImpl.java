package com.masglobalconsulting.handsOnTest.services.impl;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.mappers.EmployeeMapper;
import com.masglobalconsulting.handsOnTest.repository.EmployeeRepository;
import com.masglobalconsulting.handsOnTest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Stream<EmployeeDTO> getAll() throws IOException {
        return employeeRepository.getAll().stream()
                .map(EmployeeMapper::employeesAsEmployeeDTO);
    }

    @Override
    public Optional<EmployeeDTO> findById(Integer id) throws IOException {
        return employeeRepository.getAll().stream()
                .filter(employee -> employee.getId().equals(id))
                .map(EmployeeMapper::employeesAsEmployeeDTO)
                .findFirst();

    }
}
