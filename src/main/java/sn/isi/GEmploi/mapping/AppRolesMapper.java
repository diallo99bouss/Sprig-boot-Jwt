package sn.isi.GEmploi.mapping;

import org.mapstruct.Mapper;
import sn.isi.GEmploi.dtos.AppRoles;
import sn.isi.GEmploi.entities.AppRoleEntity;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRole(AppRoleEntity appRoleEntity); //  Transformation d'un DAO vers un DTO
    AppRoleEntity fromAppRole(AppRoles appRole);  //  Transformation d'un TDO vers un DAO

}
