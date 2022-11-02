package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "responsable")
public class Responsable extends User {


    @Enumerated(EnumType.STRING)
    private Etat etat;

    @Enumerated(EnumType.STRING)
    private TypeResponsable type;



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
