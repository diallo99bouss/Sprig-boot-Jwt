package sn.isi.GEmploi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.isi.GEmploi.dtos.AppRoles;
import sn.isi.GEmploi.entities.AppRoleEntity;
import sn.isi.GEmploi.mapping.AppRolesMapper;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class GEmploiApplication implements CommandLineRunner {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	AppRolesMapper appRolesMapper() {
		return new AppRolesMapper() {
			@Override
			public AppRoles toAppRole(AppRoleEntity appRoleEntity) {
				AppRoles appRoles = new AppRoles();
				appRoles.setId(appRoleEntity.getId());
				appRoles.setName(appRoleEntity.getName());
				return appRoles;
			}

			@Override
			public AppRoleEntity fromAppRole(AppRoles appRole) {
				return null;
			}

		};

	}*/

	public static void main(String[] args) {

		SpringApplication.run(GEmploiApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		//add role
//        AppRole appRole = new AppRole();
//        appRole.setName("USER");
//        iAppRole.save(appRole);
		//add user
//        AppUser appUser = new AppUser();
//        appUser.setLastName("Kane");
//        appUser.setFirsName("Aboubakry");
//        appUser.setEmail("kane@gmail.com");
//        appUser.setPassword("passer");
//        List<AppRole> roles = new ArrayList<AppRole>();
//        roles.add(iAppRole.findById(1));
//        roles.add(iAppRole.findById(2));
//        appUser.setRoles(roles);
//        iAppUser.save(appUser);

//        List<AppRoleEntity> appRoles = new ArrayList<>();
//               appRoles = iAppRole.findAll();
//        appRoles.forEach(role -> {
//            System.out.println(role);
//        });
	}
}
