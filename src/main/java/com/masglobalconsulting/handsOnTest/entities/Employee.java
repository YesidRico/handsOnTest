package com.masglobalconsulting.handsOnTest.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 7448495262388296790L;

    private Integer id;
    private String name;
    private String contractTypeName;
    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private Integer hourlySalary;
    private Integer monthlySalary;
}
