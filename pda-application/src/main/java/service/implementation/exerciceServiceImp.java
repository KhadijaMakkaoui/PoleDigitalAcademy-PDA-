package service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Exercice;
import repository.implementation.exerciceRepoImp;
import service.IService;

public class exerciceServiceImp implements IService<Exercice> {
    private exerciceRepoImp repo = new exerciceRepoImp();
    @Override
    public Exercice add(Exercice exercice) {return repo.add(exercice);}
    @Override
    public Exercice find(int id) {return repo.find(id);}
    @Override
    public Exercice update(Exercice exercice) {return repo.update(exercice);}
    @Override
    public void delete(Exercice exercice) {repo.delete(exercice);}
    @Override
    public List<Exercice> getAll() {return repo.getAll();}
}
