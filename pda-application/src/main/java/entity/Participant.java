package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "participant")
public class Participant extends User {


    @Column(name = "structure", length = 150)
    private String structure;

    @OneToMany(mappedBy = "participant",cascade = CascadeType.ALL)
    List<Participation> participations;



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
