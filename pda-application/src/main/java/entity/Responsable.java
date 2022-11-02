package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "responsable")
public class Responsable extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_respo", nullable = false)
    private Long id_respo;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @Enumerated(EnumType.STRING)
    private TypeResponsable type;

    public Long getId_respo() {
        return id_respo;
    }

    public void setId_respo(Long id_respo) {
        this.id_respo = id_respo;
    }

    @OneToMany(mappedBy = "responsable")
    List<Activite> activites;

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public TypeResponsable getType() {
        return type;
    }

    public void setType(TypeResponsable type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "etat='" + etat + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
