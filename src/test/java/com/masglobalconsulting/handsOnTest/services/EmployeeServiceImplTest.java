package com.masglobalconsulting.handsOnTest.services;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.entities.Employee;
import com.masglobalconsulting.handsOnTest.factories.EmployeeDTOFactory;
import com.masglobalconsulting.handsOnTest.factories.EmployeeFactory;
import com.masglobalconsulting.handsOnTest.repository.EmployeeRepository;
import com.masglobalconsulting.handsOnTest.services.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void test_should_get_all_employees() throws IOException {
        List<Employee> employees = Arrays.asList(EmployeeFactory.employeeWithContractHours(),
                EmployeeFactory.employeeWithContractMonths());

        List<EmployeeDTO> expect = Arrays.asList(EmployeeDTOFactory.employeeDTOWithContractHours(),
                EmployeeDTOFactory.employeeDTOWithContractMonths());

        when(employeeRepository.getAll())
                .thenReturn(employees);

        Assertions.assertThat(employeeService.getAll()).isEqualTo(expect);

        verify(employeeRepository, times(1)).getAll();
    }

    @Test
    public void test_should_find_employee_by_id() throws IOException {
        List<Employee> employees = Arrays.asList(EmployeeFactory.employeeWithContractHours(),
                EmployeeFactory.employeeWithContractMonths());

        Optional<EmployeeDTO> expect = Optional.of(EmployeeDTOFactory.employeeDTOWithContractMonths());

        when(employeeRepository.getAll())
                .thenReturn(employees);

        Assertions.assertThat(employeeService.findById(2)).isEqualTo(expect);

        verify(employeeRepository, times(1)).getAll();
    }

    @Test
    public void test_should_get_empty_result() throws IOException {
        List<Employee> employees = Arrays.asList(EmployeeFactory.employeeWithContractHours(),
                EmployeeFactory.employeeWithContractMonths());

        when(employeeRepository.getAll())
                .thenReturn(employees);

        Assertions.assertThat(employeeService.findById(9))
                .isEqualTo(Optional.empty());

        verify(employeeRepository, times(1)).getAll();
    }
}
