package entity;

import repository.implementation.activiteRepository;

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteRepository rep = new activiteRepository();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());
    }
}
