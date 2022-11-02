package repository.implementation;

import entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.IRepository;

import java.util.List;

public class adminRepoImp implements IRepository<Admin> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public adminRepoImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Admin add(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        return admin;
    }

    public Admin find(int id) {
        return entityManager.find(Admin.class, id);
    }

    public boolean findByLogin(String Login) {
        try {
            entityManager.getTransaction().begin();
            Query query = (Query) entityManager.createQuery("Select id from Admin where login ='" + Login+"'");
            int admin = (int) query.getSingleResult();
            entityManager.getTransaction().commit();
            if(admin>0)
                return true;
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean auth(String Login,String Password) {
        if(findByLogin(Login)){
            try {
                entityManager.getTransaction().begin();
                Query query = (Query) entityManager.createQuery("Select id from Admin WHERE password ='" + Password+"' AND login= '" + Login+"'");
                int admin = (int) query.getSingleResult();
                entityManager.getTransaction().commit();
                if(admin>0)
                    return true;

            } catch (Exception e) {
                System.out.println(e);

            }
            return false;
        }else {
            return false;
        }

    }


    public Admin update(Admin admin) {
        Admin adminToUpdate = find(admin.getId_user());

        entityManager.getTransaction().begin();
        adminToUpdate.setDomaine(admin.getDomaine());
        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setNom(admin.getNom());
        adminToUpdate.setPrenom(admin.getPrenom());
        adminToUpdate.setPhone(admin.getPhone());
        adminToUpdate.setRole(admin.getRole());
        adminToUpdate.setEtat(admin.getEtat());
        adminToUpdate.setLogin(admin.getLogin());
        adminToUpdate.setPassword(admin.getPassword());
        entityManager.getTransaction().commit();

        return adminToUpdate;
    }

    public void delete(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.remove(admin);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
