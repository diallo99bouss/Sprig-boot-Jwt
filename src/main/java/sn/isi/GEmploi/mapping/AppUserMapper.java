package sn.isi.GEmploi.mapping;

import org.mapstruct.Mapper;
import sn.isi.GEmploi.dtos.AppUser;
import sn.isi.GEmploi.entities.AppUserEntity;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity); //  Transformation d'un DAO vers un DTO
    AppUserEntity fromAppUser(AppUser appUser);  //  Transformation d'un TDO vers un DAO
}
