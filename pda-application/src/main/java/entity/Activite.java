package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activite")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activite", nullable = false)
    private int id_activite;
    @Column(name = "titre", length = 150)
    private String titre;

    @Column(name = "descriptif", length = 150)
    private String descriptif;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Enumerated(EnumType.STRING)
    private TypeActivite type;

    @Enumerated(EnumType.STRING)
    private Etat etat;
    @OneToMany(mappedBy = "activite")
    List<Participation> participations;

    @ManyToOne
    Responsable responsable;

    @OneToMany(mappedBy = "activite")
    List<Exercice> exercices;

    public int getId_activite() {
        return id_activite;
    }

    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
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

    public TypeActivite getType() {
        return type;
    }

    public void setType(TypeActivite type) {
        this.type = type;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

    @Override
    public String toString() {
        return "Activite{" +
                "id_activite=" + id_activite +
                ", titre='" + titre + '\'' +
                ", descriptif='" + descriptif + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", type='" + type + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
