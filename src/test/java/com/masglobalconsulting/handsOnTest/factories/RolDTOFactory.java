package com.masglobalconsulting.handsOnTest.factories;

import com.masglobalconsulting.handsOnTest.dto.RolDTO;

public class RolDTOFactory {

    public static RolDTO rolDtoFactoryAdministrator() {
        return RolDTO.builder()
                .roleId(1)
                .roleName("Administrator")
                .build();
    }

    public static RolDTO rolDtoFactoryContractor() {
        return RolDTO.builder()
                .roleId(2)
                .roleName("Contractor")
                .build();
    }
}
