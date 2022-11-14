package service.implementation;

import entity.Admin;
import entity.Participant;
import entity.Participation;
import repository.implementation.adminRepoImp;
import service.IService;

import java.util.List;

public class adminServiceImp implements IService<Admin> {
    private adminRepoImp repo = new adminRepoImp();
    // needs to be added to interface
    public boolean auth(String Login,String Password) {return repo.auth(Login, Password);}
    @Override
    public Admin add(Admin admin) {return repo.add(admin);}
    @Override
    public Admin find(int id) {return repo.find(id);}
    @Override
    public Admin update(Admin admin) {return repo.update(admin);}
    @Override
    public void delete(Admin admin) {repo.delete(admin);}
    @Override
    public List<Admin> getAll() {return repo.getAll();}
}
