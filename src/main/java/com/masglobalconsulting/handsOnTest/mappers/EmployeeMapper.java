package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDTO employeesAsEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .contract(ContractTypeDTOMapper.contractTypeDTOMapper(employee))
                .rol(RolDTOMapper.rolDTOMapper(employee.getRoleId(), employee.getRoleName(), employee.getRoleName()))
                .build();
    }
}
