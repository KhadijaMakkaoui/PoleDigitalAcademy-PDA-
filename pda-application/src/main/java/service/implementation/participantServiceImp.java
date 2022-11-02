package service.implementation;

import entity.Participant;
import repository.implementation.participantRepoImp;
import service.IService;

public class participantServiceImp implements IService<Participant> {
    private participantRepoImp repo = new participantRepoImp();
    @Override
    public Participant add(Participant exercice) {return repo.add(exercice);}
    @Override
    public Participant find(int id) {return repo.find(id);}
    @Override
    public Participant update(Participant exercice) {return repo.update(exercice);}
    @Override
    public void delete(Participant exercice) {repo.delete(exercice);}
}