package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {

    @Column(name = "login",unique = true, length = 150)
    private String login;

    @Column(name = "password", length = 150)
    private String password;

    @Enumerated(EnumType.STRING)
    private Etat etat;



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
