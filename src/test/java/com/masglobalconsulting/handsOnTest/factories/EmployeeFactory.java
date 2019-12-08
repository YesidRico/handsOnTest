package com.masglobalconsulting.handsOnTest.factories;

import com.masglobalconsulting.handsOnTest.entities.Employee;

public class EmployeeFactory {

    public static Employee employeeWithContractHours() {
        return Employee.builder()
                .id(1)
                .name("Juan")
                .contractTypeName("HourlySalaryEmployee")
                .roleId(1)
                .roleName("Administrator")
                .hourlySalary(60000)
                .monthlySalary(80000)
                .build();
    }

    public static Employee employeeWithContractMonths(){
        return Employee.builder()
                .id(2)
                .name("Sebastian")
                .contractTypeName("MonthlySalaryEmployee")
                .roleId(2)
                .roleName("Contractor")
                .hourlySalary(60000)
                .monthlySalary(80000)
                .build();
    }
}
