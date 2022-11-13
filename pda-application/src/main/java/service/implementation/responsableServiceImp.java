package service.implementation;

import java.util.List;

import entity.Participant;
import entity.Responsable;
import repository.implementation.responsableRepoImp;
import service.IService;

public class responsableServiceImp implements IService<Responsable> {
    private responsableRepoImp repo = new responsableRepoImp();
    @Override
    public Responsable add(Responsable responsable) {return repo.add(responsable);}
    @Override
    public Responsable find(int id) {return repo.find(id);}
    @Override
    public Responsable update(Responsable responsable) {return repo.update(responsable);}
    @Override
    public void delete(Responsable responsable) {repo.delete(responsable);}
    @Override
    public List<Responsable> getAll() {return repo.getAll();}
}