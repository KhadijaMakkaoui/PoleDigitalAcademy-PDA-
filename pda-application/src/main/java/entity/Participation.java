package entity;

import jakarta.persistence.*;

@Entity
public class Participation {
    @Column(name = "present")
    private boolean present;

    // objet activité et participant annotaion
}
