package sn.isi.GEmploi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.GEmploi.entities.AppRoleEntity;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRoleEntity, Integer> {
    Optional<AppRoleEntity> findByName(String name);
}
