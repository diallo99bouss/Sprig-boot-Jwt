package sn.isi.GEmploi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.GEmploi.entities.AppUserEntity;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    Optional<AppUserEntity> findByEmail(String email);
}
