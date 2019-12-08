package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.ContractTypeDTO;
import com.masglobalconsulting.handsOnTest.entities.Employee;
import com.masglobalconsulting.handsOnTest.factories.ContractTypeDTOFactory;
import com.masglobalconsulting.handsOnTest.factories.EmployeeFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ContractTypeDTOMapperTest {

    @Test
    public void test_should_map_as_contractdto_hourly_salary() {
        ContractTypeDTO contractTypeDTO = ContractTypeDTOFactory.contractTypeDTOFactoryHourlySalary();
        Employee employee = EmployeeFactory.employeeWithContractHours();

        ContractTypeDTO expect = ContractTypeDTOMapper.contractTypeDTOMapper(employee);

        Assertions.assertThat(contractTypeDTO).isEqualTo(expect);
    }

    @Test
    public void test_should_map_as_contractdto_mounthly_salary() {
        ContractTypeDTO contractTypeDTO = ContractTypeDTOFactory.contractTypeDTOFactoryMonthlySalary();
        Employee employee = EmployeeFactory.employeeWithContractMonths();

        ContractTypeDTO expect = ContractTypeDTOMapper.contractTypeDTOMapper(employee);

        Assertions.assertThat(contractTypeDTO).isEqualTo(expect);
    }
}
