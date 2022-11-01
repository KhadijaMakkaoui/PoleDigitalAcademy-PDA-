package entity;

import jakarta.persistence.*;

@Entity
public class Participant {
    @Column(name = "structure")
    private String structure;


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
