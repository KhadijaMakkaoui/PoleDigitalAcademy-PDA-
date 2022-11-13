package service.implementation;

import java.util.List;

import entity.Activite;
import entity.Exercice;
import repository.implementation.activiteRepoImp;
import service.IService;

public class activiteServiceImp implements IService<Activite> {
    private activiteRepoImp repo = new activiteRepoImp();
    @Override
    public Activite add(Activite activite) {return repo.add(activite);}
    @Override
    public Activite find(int id) {return repo.find(id);}
    @Override
    public Activite update(Activite activite) {return repo.update(activite);}
    @Override
    public void delete(Activite activite) {repo.delete(activite);}
    @Override
    public List<Activite> getAll() {return repo.getAll();}
}
