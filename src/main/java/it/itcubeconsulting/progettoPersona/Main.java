package it.itcubeconsulting.progettoPersona;

import it.itcubeconsulting.progettoPersona.controller.PersoneController;
import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        PersoneController personac = new PersoneController();

        boolean end = false;
        int scelta;
        do {
            System.out.println("1.INSERISCI");
            System.out.println("2.VISSUALIZZA");
            System.out.println("3.CANCELLA");
            System.out.println("4.MODIFICA");
            System.out.println("UN ALTRO NR PER USCIRE");
            System.out.println("--------------------------------");
            System.out.println("Inserisci la sua scelta :");
            // scelta = scan.nextInt();
            scelta = scan.nextInt();


            switch (scelta) {

                case 1://INSERISCI
                    System.out.println("Inserisi il nome");
                    String nome = scan.next();

                    System.out.println("Inserisi il cognome");
                    String cognome = scan.next();

                    personac.inserisci(new Persona(nome, cognome));



                    break;
                case 2://VISSUALIZZA
                    personac.visualizza();
                    break;

                case 3://CANCELLA
                    System.out.println("Inserisci il nome da cancellare.");
                    String nome1 = scan.next();
                    System.out.println("Inserisi il cognome");
                    String cognome1 = scan.next();

                    personac.cancella(new Persona(nome1,cognome1));

                    break;

                case 4://MODIFICA
                    System.out.println("Inserisci il nome da modificare.");
                    String nome2 = scan.next();
                    System.out.println("Inserisi il cognome");
                    String cognome2 = scan.next();

                    personac.modifica(new Persona(nome2,cognome2));

                    break;
                case 0:
                    end = true;
                    break;
            }
        }
        while (scelta == 1 || scelta == 2 || scelta == 3 || scelta == 4);
     //   while (!end);
    }
}

