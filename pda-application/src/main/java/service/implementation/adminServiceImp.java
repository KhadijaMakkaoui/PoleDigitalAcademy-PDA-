package service.implementation;

import entity.Admin;
import repository.implementation.adminRepoImp;
import service.IService;

public class adminServiceImp implements IService<Admin> {
    private adminRepoImp repo = new adminRepoImp();
    @Override
    public Admin add(Admin admin) {return repo.add(admin);}
    @Override
    public Admin find(int id) {return repo.find(id);}
    @Override
    public Admin update(Admin admin) {return repo.update(admin);}
    @Override
    public void delete(Admin admin) {repo.delete(admin);}
}