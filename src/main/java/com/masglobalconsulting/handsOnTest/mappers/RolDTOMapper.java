package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.RolDTO;

public class RolDTOMapper {

    public static RolDTO rolDTOMapper(Integer rolId, String rolName, String rolDescription){
        return RolDTO.builder()
                .roleId(rolId)
                .roleName(rolName)
                .roleDescription(rolDescription)
                .build();
    }
}
