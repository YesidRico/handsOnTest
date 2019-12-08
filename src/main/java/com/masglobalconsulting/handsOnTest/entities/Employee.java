package com.masglobalconsulting.handsOnTest.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
