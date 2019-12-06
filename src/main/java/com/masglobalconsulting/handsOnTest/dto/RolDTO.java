package com.masglobalconsulting.handsOnTest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolDTO {
    private Integer roleId;
    private String roleName;
    private String roleDescription;
}
