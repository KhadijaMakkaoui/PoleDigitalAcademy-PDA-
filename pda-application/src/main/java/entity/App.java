package entity;

import repository.implementation.activiteImp;

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteImp rep = new activiteImp();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());
    }
}
