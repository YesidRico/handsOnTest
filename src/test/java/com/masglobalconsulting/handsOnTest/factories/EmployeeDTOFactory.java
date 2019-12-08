package com.masglobalconsulting.handsOnTest.factories;

import com.masglobalconsulting.handsOnTest.dto.ContractTypeDTO;
import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.dto.RolDTO;

public class EmployeeDTOFactory {

    public static EmployeeDTO employeeDTOWithContractHours(){
        return EmployeeDTO.builder()
                .id(1)
                .name("Juan")
                .rol(RolDTO.builder()
                        .roleId(1)
                        .roleName("Administrator")
                        .build())
                .contract(ContractTypeDTO.builder()
                        .contractType("HourlySalaryEmployee")
                        .hourlySalary(60000)
                        .monthlySalary(80000)
                        .annualSalary(120 * 60000 * 12)
                        .build())
                .build();
    }

    public static EmployeeDTO employeeDTOWithContractMonths(){
        return EmployeeDTO.builder()
                .id(2)
                .name("Sebastian")
                .rol(RolDTO.builder()
                        .roleId(2)
                        .roleName("Contractor")
                        .build())
                .contract(ContractTypeDTO.builder()
                        .contractType("MonthlySalaryEmployee")
                        .hourlySalary(60000)
                        .monthlySalary(80000)
                        .annualSalary(80000 * 12)
                        .build())
                .build();
    }
}
