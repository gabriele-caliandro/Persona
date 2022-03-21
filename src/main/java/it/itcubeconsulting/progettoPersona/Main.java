package it.itcubeconsulting.progettoPersona;

import it.itcubeconsulting.progettoPersona.controller.PersoneController;
import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Random rand = new Random();
        int maxNumber = 100000;
        Scanner scan = new Scanner(System.in);
        PersoneController personac = new PersoneController();

        boolean end = false;
        int scelta;
        do {
            System.out.println("1.INSERISCI");
            System.out.println("2.VISSUALIZZA");
            System.out.println("3.CANCELLA");
            System.out.println("4.MODIFICA");
            System.out.println("0.USCITA");
            System.out.println("--------------------------------");
            System.out.println("INSERISCI LA SUA OPZIONE :");
            scelta = scan.nextInt();


            switch (scelta) {

                case 1://INSERISCI
                    System.out.println("INSERISCI IL NOME:");
                    String nome = scan.next();

                    System.out.println("INSERISCI IL COGNOME");
                    String cognome = scan.next();

                    int id = rand.nextInt(maxNumber) + 1;
                    personac.inserisci(new Persona(id,nome, cognome));


                    break;
                case 2://VISSUALIZZA
                    personac.visualizza();
                    break;

                case 3://CANCELLA
                    System.out.println("INSERISCI L'ID PERSONA DA CANCELLARE.");
                    int idCancellare = scan.nextInt();
                    personac.cancella(idCancellare);
                    break;

                case 4://MODIFICA
                    System.out.println("INSERISCI L'ID PERSONA DA MODIFICARE.");
                    int idModificare = scan.nextInt();

                    if (!(personac.modifica(idModificare))){
                        System.out.println("ID NON TROVATO");
                    }

                    break;
                case 0:
                    end = true;
                    break;
            }
        }
        // while (scelta == 1 || scelta == 2 || scelta == 3 || scelta == 4);
        while (!end);
    }
}

