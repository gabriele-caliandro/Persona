package it.itcubeconsulting.progettoPersona.model;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.util.*;

public class PersoneController {

    List<Persona> lista = new ArrayList<Persona>();

    Scanner scan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    int scelta;


    {
        do {
            System.out.println("1.INSERISCI");
            System.out.println("2.VISSUALIZZA");
            System.out.println("3.CANCELLA");
            System.out.println("4.MODIFICA");
            System.out.println("UN ALTRO NR PER USCIRE");
            System.out.println("--------------------------------");
            System.out.println("Inserisci la sua scelta :");
            scelta = scan.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome: ");
                    String name = scan1.nextLine();
                    System.out.println("Inserisci il cognome: ");
                    String surname = scan1.next();
                    lista.add(new Persona(name, surname));
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    Iterator<Persona> i = lista.iterator();
                    if (lista.isEmpty()) {
                        System.out.println("La lista nomi e vuota");
                        System.out.println("--------------------------------");
                    } else {
                        while (i.hasNext()) {
                            Persona p = i.next();
                            System.out.println(p);
                        }
                   /* for (Persona p : lista) {
                        System.out.println(p);
                    }*/
                        System.out.println("--------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("--------------------------------");
                    boolean bn = false;
                    System.out.println("Inserisci il nome da cancellare");
                    name = scan.nextLine();
                    i = lista.iterator();
                    while (i.hasNext()) {
                        Persona p = i.next();
                        if (Objects.equals(p.getNome(), name)) {
                            i.remove();
                            bn = true;
                        }
                    }
                    if (!bn) {
                        System.out.println("Nome inserito non trovato...Prova di nuovo");
                    } else {
                        System.out.println("Nome inserito e stato cancellato con successo!");
                    }
                    System.out.println("--------------------------------");

                    break;

                case 4:
                    System.out.println("--------------------------------");
                    boolean b = false;
                    //ListIterator e non Iterator per modificare.

                    System.out.println("Inserisci il nome da modificare");
                    name = scan.nextLine();
                    ListIterator<Persona> li = lista.listIterator();
                    if (lista.isEmpty()){
                        System.out.println("Non esistono ancora nomi da modificare!!");
                    }
                    // i = lista.iterator();
                    while (li.hasNext()) {
                        Persona p = li.next();
                        if (Objects.equals(p.getNome(), name)) {

                            System.out.println("Inserisci il nuovo nome: ");
                            String name1 = scan1.nextLine();
                            System.out.println("Inserisci il nuovo cognome: ");
                            String surname1 = scan1.next();

                            li.set(new Persona(name1, surname1));
                            b = true;
                        }
                    }
                    if (!b) {
                        System.out.println("Nome inserito non trovato...Prova di nuovo");
                    } else {
                        System.out.println("Nome inserito e stato modificato con successo!");
                    }
                    System.out.println("--------------------------------");

                    break;
            }
                 }while(scelta == 1 || scelta == 2 || scelta == 3 || scelta == 4);
        }


}
