package sn.isi.GEmploi.services;

import sn.isi.GEmploi.dtos.AppUser;

public interface IAppUserService extends IBaseService<AppUser> {
    AppUser loadUserByEmail(String email);
    public AppUser findById(int id);
    public void delete(int id);
    public AppUser update(int id, AppUser appUser);
}
