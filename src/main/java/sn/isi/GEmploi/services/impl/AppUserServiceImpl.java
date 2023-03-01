package sn.isi.GEmploi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.isi.GEmploi.dtos.AppUser;
import sn.isi.GEmploi.entities.AppUserEntity;
import sn.isi.GEmploi.exception.EntityNotFoundException;
import sn.isi.GEmploi.exception.RequestException;
import sn.isi.GEmploi.mapping.AppUserMapper;
import sn.isi.GEmploi.repositories.AppUserRepository;
import sn.isi.GEmploi.services.IAppUserService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements IAppUserService {

    private AppUserRepository appUserRepository;
    private AppUserMapper appUserMapper;
    private MessageSource messageSource;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser loadUserByEmail(String email) {
        return appUserMapper.toAppUser(appUserRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{email},
                        Locale.getDefault()))));
    }

    @Override
    public AppUser findById(int id) {
        return appUserMapper.toAppUser(appUserRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Override
    public void delete(int id) {
        try {
            appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Override
    public AppUser update(int id, AppUser appUser) {
        return appUserRepository.findById(id)
                .map(entity -> {
                    appUser.setId(id);
                    return appUserMapper.toAppUser(
                            appUserRepository.save(appUserMapper.fromAppUser(appUser)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Override
    public AppUser save(AppUser appUser) {
        appUserRepository.findByEmail(appUser.getEmail())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("user.exists", new Object[]{appUser.getEmail()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        String password = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(password));
        AppUserEntity re = appUserMapper.fromAppUser(appUser);
        re = appUserRepository.save(re);
        return  appUserMapper.toAppUser(re);
    }

    @Override
    public List<AppUser> findAll() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }
}
