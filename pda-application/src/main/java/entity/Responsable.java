package entity;

import jakarta.persistence.*;

@Entity
public class Responsable {
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @Enumerated(EnumType.STRING)
    private TypeResponsable type;


    // listDesActivites needs to be implemented with hibernate annotation


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
