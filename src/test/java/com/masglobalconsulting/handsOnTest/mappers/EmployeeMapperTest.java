package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.entities.Employee;
import com.masglobalconsulting.handsOnTest.factories.EmployeeDTOFactory;
import com.masglobalconsulting.handsOnTest.factories.EmployeeFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EmployeeMapperTest {

    @Test
    public void test_should_map_employee_as_employeedto() {
        EmployeeDTO employeeDTO = EmployeeDTOFactory.employeeDTOWithContractHours();
        Employee employee = EmployeeFactory.employeeWithContractHours();

        EmployeeDTO expect = EmployeeMapper.employeesAsEmployeeDTO(employee);

        Assertions.assertThat(employeeDTO).isEqualTo(expect);
    }
}
