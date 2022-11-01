package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "present")
    private boolean present;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // objet activité et participant annotaion
}
