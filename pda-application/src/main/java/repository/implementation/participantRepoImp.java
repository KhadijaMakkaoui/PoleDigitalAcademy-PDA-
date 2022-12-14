package repository.implementation;

import java.util.List;

import entity.Exercice;
import entity.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import repository.IRepository;

public class participantRepoImp implements IRepository<Participant> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public participantRepoImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Participant add(Participant participant) {
        entityManager.getTransaction().begin();
        entityManager.persist(participant);
        entityManager.getTransaction().commit();
        return participant;
    }
    
    @SuppressWarnings("unchecked")
	public List<Participant> getAll() {
        Query query = entityManager.createNativeQuery("select * from participant", Participant.class);
        return query.getResultList();
    }


    public Participant find(int id) {
        return entityManager.find(Participant.class, id);
    }

    public Participant update(Participant participant) {
        Participant participantToUpdate = find(participant.getId_user());

        entityManager.getTransaction().begin();
        participantToUpdate.setDomaine(participant.getDomaine());
        participantToUpdate.setEmail(participant.getEmail());
        participantToUpdate.setNom(participant.getNom());
        participantToUpdate.setPrenom(participant.getPrenom());
        participantToUpdate.setPhone(participant.getPhone());
        participantToUpdate.setRole(participant.getRole());
        participantToUpdate.setStructure(participant.getStructure());
        entityManager.getTransaction().commit();

        return participantToUpdate;
    }

    public void delete(Participant participant) {
        entityManager.getTransaction().begin();
        entityManager.remove(participant);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
