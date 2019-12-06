package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.ContractTypeDTO;
import com.masglobalconsulting.handsOnTest.entities.Employee;

public class ContractTypeDTOMapper {

    public static ContractTypeDTO contractTypeDTOMapper(Employee employee) {
        return ContractTypeDTO.builder()
                .contractType(employee.getContractTypeName())
                .hourlySalary(employee.getHourlySalary())
                .monthlySalary(employee.getMonthlySalary())
                .annualSalary(getAnnualSalaryByContractType(employee))
                .build();
    }

    private static Integer getAnnualSalaryByContractType(Employee employee) {
        return employee.getContractTypeName().equals(ContractTypeDTO.HOURLY_SALARY_EMPLOYEE) ?
                calculateAnnualSalaryByHourly(employee.getHourlySalary()) :
                calculateAnnualSalaryByMonthly(employee.getMonthlySalary());
    }

    private static Integer calculateAnnualSalaryByHourly(Integer hourlySalary) {
        return 120 * hourlySalary * 12;
    }

    private static Integer calculateAnnualSalaryByMonthly(Integer monthlySalary) {
        return monthlySalary * 12;
    }
}
