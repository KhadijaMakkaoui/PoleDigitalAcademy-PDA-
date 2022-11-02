package repository.implementation;

import entity.Participation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.IRepository;

public class participationRepoImp implements IRepository<Participation> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public participationRepoImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Participation add(Participation participation) {
        entityManager.getTransaction().begin();
        entityManager.persist(participation);
        entityManager.getTransaction().commit();
        return participation;
    }

    public Participation find(int id) {
        return entityManager.find(Participation.class, id);
    }

    public Participation update(Participation participation) {
        Participation participationToUpdate = find(participation.getId());

        entityManager.getTransaction().begin();

        participationToUpdate.setParticipant(participation.getParticipant());
        participationToUpdate.setActivite(participation.getActivite());
        participationToUpdate.setPresent(participation.isPresent());

        entityManager.getTransaction().commit();

        return participationToUpdate;
    }

    public void delete(Participation participation) {
        entityManager.getTransaction().begin();
        entityManager.remove(participation);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
