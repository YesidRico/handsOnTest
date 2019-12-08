package com.masglobalconsulting.handsOnTest.factories;

import com.masglobalconsulting.handsOnTest.dto.ContractTypeDTO;

public class ContractTypeDTOFactory {

    public static ContractTypeDTO contractTypeDTOFactoryHourlySalary() {
        return ContractTypeDTO.builder()
                .contractType("HourlySalaryEmployee")
                .hourlySalary(60000)
                .monthlySalary(80000)
                .annualSalary(120 * 60000 * 12)
                .build();
    }

    public static ContractTypeDTO contractTypeDTOFactoryMonthlySalary() {
        return ContractTypeDTO.builder()
                .contractType("MonthlySalaryEmployee")
                .hourlySalary(60000)
                .monthlySalary(80000)
                .annualSalary(80000 * 12)
                .build();
    }
}
