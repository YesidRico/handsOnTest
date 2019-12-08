package com.masglobalconsulting.handsOnTest.rest.web;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.exceptions.InternalServerException;
import com.masglobalconsulting.handsOnTest.exceptions.NotFoundException;
import com.masglobalconsulting.handsOnTest.factories.EmployeeDTOFactory;
import com.masglobalconsulting.handsOnTest.services.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    @DisplayName("should get all employees as EmployeesDTO")
    public void test_get_all_employees() throws IOException {

        List<EmployeeDTO> employeeDTOS = Arrays.asList(EmployeeDTOFactory.employeeDTOWithContractHours(),
                EmployeeDTOFactory.employeeDTOWithContractMonths());

        when(employeeService.getAll())
                .thenReturn(employeeDTOS.stream());

        Assertions.assertThat(employeeController.getAllEmployees())
                .isEqualTo(employeeDTOS);

        verify(employeeService, times(1)).getAll();
    }

    @Test
    @DisplayName("should get annual an annual salary from an hourly contract")
    public void test_get_annual_salary_hourly_contract() throws IOException {
        List<EmployeeDTO> employeeDTOS = Arrays.asList(EmployeeDTOFactory.employeeDTOWithContractHours(),
                EmployeeDTOFactory.employeeDTOWithContractMonths());

        when(employeeService.getAll())
                .thenReturn(employeeDTOS.stream());

        EmployeeDTO employeeDTO = employeeController.getAllEmployees().stream()
                .filter(e -> e.getContract().getContractType().equals("HourlySalaryEmployee"))
                .findFirst()
                .orElse(EmployeeDTO.builder().build());

        Assertions.assertThat(employeeDTO.getContract().getAnnualSalary())
                .isEqualTo(120 * employeeDTO.getContract().getHourlySalary() * 12);

        verify(employeeService, times(1)).getAll();
    }

    @Test
    @DisplayName("should get an annual salary from a contract for months")
    public void test_get_annual_salary_contract_months() throws IOException {
        List<EmployeeDTO> employeeDTOS = Arrays.asList(EmployeeDTOFactory.employeeDTOWithContractHours(),
                EmployeeDTOFactory.employeeDTOWithContractMonths());

        when(employeeService.getAll())
                .thenReturn(employeeDTOS.stream());

        EmployeeDTO employeeDTO = employeeController.getAllEmployees().stream()
                .filter(e -> e.getContract().getContractType().equals("MonthlySalaryEmployee"))
                .findFirst()
                .orElse(EmployeeDTO.builder().build());

        Assertions.assertThat(employeeDTO.getContract().getAnnualSalary())
                .isEqualTo(employeeDTO.getContract().getMonthlySalary() * 12);

        verify(employeeService, times(1)).getAll();
    }


    @Test
    @DisplayName("should launch IOException and capture the Exception when getting employees")
    public void test_get_ioexception() throws IOException {
        when(employeeService.getAll())
                .thenThrow(new IOException());

        assertThrows(InternalServerException.class, () -> employeeController.getAllEmployees());

        verify(employeeService, times(1)).getAll();
    }


    @Test
    @DisplayName("should get employee by id")
    public void test_find_by_id() throws IOException {
        EmployeeDTO employeeDTO = EmployeeDTOFactory.employeeDTOWithContractHours();

        when(employeeService.findById(anyInt()))
                .thenReturn(Optional.of(employeeDTO));

        Assertions.assertThat(employeeController.findById(1))
                .isEqualTo(employeeDTO);

        verify(employeeService, times(1)).findById(1);

    }

    @Test
    @DisplayName("should throw NotFoundException when you don't find an employee by id")
    public void test_should_notfoundexception() throws IOException {
        when(employeeService.findById(anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> employeeController.findById(10));
    }

    @Test
    @DisplayName("should launch IOException and capture the Exception when getting employees")
    public void test_find_by_id_ioexception() throws IOException {
        when(employeeService.findById(anyInt()))
                .thenThrow(new IOException());

        assertThrows(InternalServerException.class, () -> employeeController.findById(1));

        verify(employeeService, times(1)).findById(1);
    }

}
