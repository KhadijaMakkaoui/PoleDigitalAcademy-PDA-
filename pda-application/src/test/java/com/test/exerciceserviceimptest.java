package com.test;

import entity.Status;
import org.junit.jupiter.api.Test;
import service.implementation.exerciceServiceImp;
import entity.Exercice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class exerciceserviceimptest {
    protected SimpleDateFormat sdf = null;

    @Test
    void add() throws ParseException {
        exerciceServiceImp eximp = new exerciceServiceImp();
        Exercice e = new Exercice();

        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDeb = "2021-01-01";
        Date debut = sdf.parse(dateDeb);
        String dateFin = "2022-02-02";
        Date fin = sdf.parse(dateFin);


        e.setAnnee("2020");
        e.setDate_debut(debut);
        e.setDate_fin(fin);
        e.setStatus(Status.valueOf("ENCOURS"));

        Exercice result =  eximp.add(e);

        assertSame(result,e);
    }

    @Test
    void find() {
        exerciceServiceImp eximp = new exerciceServiceImp();
        Exercice e = new Exercice();

        e.setAnnee("2020");
        e.setStatus(Status.valueOf("ENCOURS"));

        eximp.add(e);
        Exercice result =  eximp.find(e.getId_exercice());

        assertSame(result,e);
    }

    @Test
    void update() throws ParseException {
        exerciceServiceImp eximp = new exerciceServiceImp();
        Exercice e = new Exercice();

        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDeb = "2021-01-01";
        Date debut = sdf.parse(dateDeb);
        String dateFin = "2022-02-02";
        Date fin = sdf.parse(dateFin);

        e.setAnnee("2020");
        e.setDate_debut(debut);
        e.setDate_fin(fin);
        e.setStatus(Status.valueOf("ENCOURS"));
        eximp.add(e);

        e.setAnnee("2022");
        e.setStatus(Status.valueOf("TERMINER"));

        Exercice result =  eximp.update(e);

        assertSame(result,e);
    }

    @Test
    void delete() {
        exerciceServiceImp eximp = new exerciceServiceImp();
        Exercice e = new Exercice();

        e.setAnnee("2020");
        e.setStatus(Status.valueOf("ENCOURS"));

        eximp.add(e);
        eximp.delete(e);
        Exercice result =  eximp.find(e.getId_exercice());

        assertNull(result);
    }

    @Test
    void getAll() throws ParseException {
        exerciceServiceImp eximp = new exerciceServiceImp();
        Exercice e = new Exercice();

        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateDeb = "2021-01-01";
        Date debut = sdf.parse(dateDeb);
        String dateFin = "2022-02-02";
        Date fin = sdf.parse(dateFin);

        e.setAnnee("2020");
        e.setDate_debut(debut);
        e.setDate_fin(fin);
        e.setStatus(Status.valueOf("ENCOURS"));

        eximp.add(e);

        List<Exercice> resultlist = eximp.getAll();

        assertNotNull(resultlist);
    }
}