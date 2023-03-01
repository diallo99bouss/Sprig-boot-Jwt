package sn.isi.GEmploi.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.isi.GEmploi.dtos.AppRoles;
import sn.isi.GEmploi.services.IAppRoleService;

import java.util.List;


@RestController
@RequestMapping(value = "roles")
@AllArgsConstructor
public class AppRoleController {

    private IAppRoleService iAppRoleService;

    @PostMapping(path = "/save")
    public AppRoles save(@Valid @RequestBody AppRoles appRoles){
        return iAppRoleService.save(appRoles);
    }

    @GetMapping
    public List<AppRoles> findAll() {
        return iAppRoleService.findAll();
    }

    @GetMapping(path = "/{name}")
    public AppRoles getAppRole(@PathVariable("name") String name) {
        return iAppRoleService.findByName(name);
    }

    @PutMapping(path = "/{name}")
    public AppRoles updateAppRole(@PathVariable("name") String name, @Valid @RequestBody AppRoles appRoles) {
        return iAppRoleService.update(name, appRoles);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppRole(@PathVariable("id") int id) {
        iAppRoleService.delete(id);
    }

}
