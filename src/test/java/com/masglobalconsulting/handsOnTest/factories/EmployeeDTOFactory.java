package com.masglobalconsulting.handsOnTest.factories;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;

public class EmployeeDTOFactory {

    public static EmployeeDTO employeeDTOWithContractHours(){
        return EmployeeDTO.builder()
                .id(1)
                .name("Juan")
                .rol(RolDTOFactory.rolDtoFactoryAdministrator())
                .contract(ContractTypeDTOFactory.contractTypeDTOFactoryHourlySalary())
                .build();
    }

    public static EmployeeDTO employeeDTOWithContractMonths(){
        return EmployeeDTO.builder()
                .id(2)
                .name("Sebastian")
                .rol(RolDTOFactory.rolDtoFactoryContractor())
                .contract(ContractTypeDTOFactory.contractTypeDTOFactoryMonthlySalary())
                .build();
    }
}
