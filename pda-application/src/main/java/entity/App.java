package entity;

import service.implementation.exerciceServiceImp;

import java.util.ArrayList;
import java.util.List;
import entity.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import repository.implementation.exerciceRepoImp;




public class App {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        //Activite activite = new Activite();
        //activite.setTitre("testing");

        //activiteRepoImp rep = new activiteRepoImp();
        //rep.add(activite);
        //System.out.println("added activite"+ activite.toString());

        /*Admin admin = new Admin();
        admin.setLogin("khadija");
        admin.setPassword("123");
        adminServiceImp asi = new adminServiceImp();
        asi.add(admin);



        boolean asicon = asi.auth("khadija", "123");
        System.out.println(asicon);

         */
    	
    	
    	
    	/*
        exerciceServiceImp ex = new exerciceServiceImp();


        Exercice exercice=new Exercice();
        exercice.setAnnee("2004");



        Exercice added = ex.add(exercice);
        System.out.println(added);
        
    	try {
        	exerciceServiceImp ex = new exerciceServiceImp();
            RequestDispatcher dispatcher = null;
            Exercice exercice=new Exercice();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


            String dateDeb = "2010-01-10";
            Date debut = sdf.parse(dateDeb);

            String dateFin = "2010-01-20";
            Date fin = sdf.parse(dateFin);
            
            String ann = "2020";
            String stat = "ENCOURS";
            
            exercice.setDate_debut(debut);
            exercice.setDate_fin(fin);
            exercice.setAnnee(ann);
            exercice.setStatus(Status.valueOf(stat));

            Exercice added = ex.add(exercice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*
		ArrayList <Exercice> exList = ex.getAllExercice();
		for(Exercice exercice : exList) {
			
		}*
		*
		exerciceServiceImp ex = new exerciceServiceImp();
		Collection exList = (Collection) ex.getAllExercice();
		
		if(exList != null) {
			System.out.println("yes");
		}*
		*/
   
    	
    	exerciceServiceImp ex = new exerciceServiceImp();
    	List<Exercice> exlist = null;
		
		
		
		exlist = ex.getAllExercice().stream().limit(10).collect(Collectors.toList());
		for(Exercice exercice : exlist) {
			System.out.println(exercice);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
