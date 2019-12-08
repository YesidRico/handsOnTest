package com.masglobalconsulting.handsOnTest.mappers;

import com.masglobalconsulting.handsOnTest.dto.RolDTO;
import com.masglobalconsulting.handsOnTest.factories.RolDTOFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RolDTOMapperTest {

    @Test
    public void test_should_map_as_rol_administractor(){
        RolDTO rolDTO = RolDTOFactory.rolDtoFactoryAdministrator();
        RolDTO expect = RolDTOMapper.rolDTOMapper(1, "Administrator", null);

        Assertions.assertThat(rolDTO).isEqualTo(expect);
    }
}
