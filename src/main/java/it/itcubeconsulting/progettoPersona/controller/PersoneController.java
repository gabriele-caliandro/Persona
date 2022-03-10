package it.itcubeconsulting.progettoPersona.controller;
import it.itcubeconsulting.progettoPersona.model.Persona;

import java.util.*;

public class PersoneController {
    // param ingresso lista e scanner input
    private ArrayList<Persona> lista = new ArrayList<Persona>();
    private Scanner scan;


    //costruttori di param
    public PersoneController(ArrayList lista, Scanner scan) {
        this.lista = lista;
        this.scan = scan;
    }

    public void inserisci(ArrayList lista, Scanner scan) {
        System.out.println("Inserisci il nome: ");
        String name = scan.nextLine();
        System.out.println("Inserisci il cognome: ");
        String surname = scan.nextLine();
        lista.add(new Persona(name, surname));
    }

    public void vissualizza(ArrayList lista, Scanner scan) {
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
    }

    public void cancella(ArrayList lista, Scanner scan) {
        System.out.println("--------------------------------");
        boolean bn = false;
        System.out.println("Inserisci il nome da cancellare");
        String name = scan.nextLine();

        //System.out.println("Inserisci il nome da cancellare");
        //String surname = scan.nextLine();
        Iterator<Persona> i = lista.iterator();
        while (i.hasNext()) {
            Persona p = i.next();
//            if (Objects.equals(p.getCognome(), surname)) {
//                i.remove();
//                bn = true;
//            }
            if (p.getNome().equals(name)) {
                //&&  p.getCognome().equals(surname)
                i.remove();
                bn = true;
            }

            // cancella con nome e cognome
//            if (p.getNome().equals(name)) {
//                if (p.getCognome().equals(cognome)) {
//                    i.remove();
//                    bn = true;
//                }
//            }
        }
        if (!bn) {
            System.out.println("Nome inserito non trovato...Prova di nuovo");
        } else {
            System.out.println("Nome inserito e stato cancellato con successo!");
        }
        System.out.println("--------------------------------");

    }

    public void modifica(ArrayList lista, Scanner scan) {
        System.out.println("--------------------------------");
        boolean b = false;
        //ListIterator e non Iterator per modificare.

        System.out.println("Inserisci il nome da modificare");
        String name = scan.nextLine();
        ListIterator<Persona> li = lista.listIterator();
        if (lista.isEmpty()) {
            System.out.println("Non esistono ancora nomi da modificare!!");
        }
        // i = lista.iterator();
        while (li.hasNext()) {
            Persona p = li.next();
            if (Objects.equals(p.getNome(), name)) {

                System.out.println("Inserisci il nuovo nome: ");
                String name1 = scan.nextLine();
                System.out.println("Inserisci il nuovo cognome: ");
                String surname1 = scan.nextLine();

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

    }
}
