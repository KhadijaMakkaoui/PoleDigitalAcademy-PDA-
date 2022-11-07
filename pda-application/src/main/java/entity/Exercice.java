package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "exercice")
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercice", nullable = false)
    private int id_exercice;
    @Column(name = "annee", length = 150)
    private String annee;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    // enum change to string annotations
    @Enumerated(EnumType.STRING)
    private Status status;

    //needs to add object activite
    @ManyToOne
    Activite activite;

    public int getId_exercice() {
        return id_exercice;
    }

    public void setId_exercice(int id_exercice) {
        this.id_exercice = id_exercice;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "id_exercice=" + id_exercice +
                ", annee='" + annee + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", status='" + status + '\'' +
                '}';
    }
}
