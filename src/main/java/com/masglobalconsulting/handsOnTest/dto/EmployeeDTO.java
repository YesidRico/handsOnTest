package com.masglobalconsulting.handsOnTest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private RolDTO rol;
    private ContractTypeDTO contract;
}
