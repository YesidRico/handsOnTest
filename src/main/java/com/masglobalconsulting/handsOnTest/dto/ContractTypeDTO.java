package com.masglobalconsulting.handsOnTest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractTypeDTO {
    public static final String HOURLY_SALARY_EMPLOYEE = "HourlySalaryEmployee";
    public static final String MONTHLY_SALARY_EMPLOYEE = "MonthlySalaryEmployee";

    private String contractType;
    private Integer hourlySalary;
    private Integer monthlySalary;
    private Integer annualSalary;
}
