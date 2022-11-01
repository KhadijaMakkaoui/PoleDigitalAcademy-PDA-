package entity;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    private int id_role;
    @Column(name = "role")
    private String role;

    public int getId() {
        return id_role;
    }

    public void setId(int id) {
        this.id_role = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id_role +
                ", role='" + role + '\'' +
                '}';
    }
}
