package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_participation", nullable = false)
    private int id_participation;

    @Column(name = "present")
    private boolean present;


    @ManyToOne(fetch = FetchType.LAZY)
    Activite activite;

    @ManyToOne(fetch = FetchType.LAZY)
    Participant participant;

    public boolean isPresent() {
        return present;
    }
    

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public int getId() {
        return id_participation;
    }

    public void setId(int id) {
        this.id_participation = id;
    }

}
