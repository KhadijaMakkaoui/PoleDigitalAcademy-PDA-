package service.implementation;

import entity.Participation;
import repository.implementation.participationRepoImp;
import service.IService;

public class participationServiceImp implements IService<Participation> {
    private participationRepoImp repo = new participationRepoImp();
    @Override
    public Participation add(Participation participation) {return repo.add(participation);}
    @Override
    public Participation find(int id) {return repo.find(id);}
    @Override
    public Participation update(Participation participation) {return repo.update(participation);}
    @Override
    public void delete(Participation participation) {repo.delete(participation);}
}