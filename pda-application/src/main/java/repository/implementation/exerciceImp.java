package repository.implementation;

import entity.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.IRepository;

public class exerciceImp implements IRepository<Exercice> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public exerciceImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Exercice add(Exercice exercice) {
        entityManager.getTransaction().begin();
        entityManager.persist(exercice);
        entityManager.getTransaction().commit();
        return exercice;
    }

    public Exercice find(int id) {
        return entityManager.find(Exercice.class, id);
    }

    public Exercice update(Exercice exercice) {
        Exercice exerciceToUpdate = find(exercice.getId_exercice());

        entityManager.getTransaction().begin();

        exerciceToUpdate.setAnnee(exercice.getAnnee());
        exerciceToUpdate.setDate_debut(exercice.getDate_debut());
        exerciceToUpdate.setDate_fin(exercice.getDate_fin());
        exerciceToUpdate.setStatus(exercice.getStatus());

        entityManager.getTransaction().commit();

        return exerciceToUpdate;
    }

    public void delete(Exercice exercice) {
        entityManager.getTransaction().begin();
        entityManager.remove(exercice);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
