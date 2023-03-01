package sn.isi.GEmploi.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.isi.GEmploi.dtos.AppUser;
import sn.isi.GEmploi.services.IAppUserService;

import java.util.List;


@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class AppUserController {

    private IAppUserService iAppUserService;

    @PostMapping(path = "/save")
    public AppUser save(@Valid @RequestBody AppUser appUser){
        return iAppUserService.save(appUser);
    }

    @GetMapping
    public List<AppUser> findAll() {
        return iAppUserService.findAll();
    }

    @GetMapping(path = "/{id}")
    public AppUser getAppUser(@PathVariable("id") int id) {
        return iAppUserService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public AppUser updateAppRole(@PathVariable("id") int id, @Valid @RequestBody AppUser appUser) {
        return iAppUserService.update(id, appUser);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppRole(@PathVariable("id") int id) {
        iAppUserService.delete(id);
    }

}
