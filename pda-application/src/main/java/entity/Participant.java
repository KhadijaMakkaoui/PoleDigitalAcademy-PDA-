package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_p", nullable = false)
    private Long id_p;

    @Column(name = "structure", length = 150)
    private String structure;

    @OneToMany(mappedBy = "participant")
    List<Participation> participations;
    public Long getId_p() {
        return id_p;
    }

    public void setId_p(Long id_p) {
        this.id_p = id_p;
    }


    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "structure='" + structure + '\'' +
                '}';
    }
}
