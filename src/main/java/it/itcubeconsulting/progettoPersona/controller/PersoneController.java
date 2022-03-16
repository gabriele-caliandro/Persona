package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;
import it.itcubeconsulting.progettoPersona.repository.RepositoryPersona;

import java.io.*;
import java.util.*;

public class PersoneController implements IpersonaController {

    private ArrayList<Persona> lista = new ArrayList<Persona>();
    RepositoryPersona repositoyController = new RepositoryPersona();

    public PersoneController() throws IOException {
    }


    @Override
    public void inserisci(Persona persona) throws IOException, ClassNotFoundException {
        Persona personaToFile = new Persona(persona.getNome(),persona.getCognome());
        repositoyController.inserisciPersonaFile(personaToFile);

        lista.add(persona);

        // inderire nella db

        //System.out.println(lista);

    }

    @Override
    public List<Persona> visualizza() throws IOException, ClassNotFoundException {

        Iterator<Persona> i = lista.iterator();
        if (lista.isEmpty()) {
            System.out.println("La lista e vuota,non ci sono persone da visualizzare");
        } else {
            while (i.hasNext()) {
                Persona p = i.next();
                System.out.println(p);
            }
        } repositoyController.leggiPersonaFile();
        return null;
    }

    @Override
    public boolean cancella(Persona persona) throws IOException {

        boolean bool = false;
        String n = persona.getNome();
        String c = persona.getCognome();

        repositoyController.cancellaPersonaFIle(new Persona(n,c));

        Iterator<Persona> i = lista.iterator();
        while (i.hasNext()) {
            Persona p = i.next();
            if (p.getNome().equals(n) && (p.getCognome().equals(c))) {
                i.remove();
                bool = true;
                System.out.println("Nome " + n + " " + c + " cancellati con successo");
            } else {
                System.out.println("nome richiesto non trovato");
            }

            bool = false;
        }

        return bool;

    }

    @Override
    public Persona modifica(Persona persona) {

        ListIterator<Persona> li = lista.listIterator();
        String n1 = persona.getNome();
        String c1 = persona.getCognome();
        for (Persona p : lista) {
            if (p.getNome().equals(n1) && (p.getCognome().equals(c1))) {
                li.set(new Persona(n1, c1));
                System.out.println("Nome " + n1 + " " + c1 + " modificato con successo");
            } else {
                System.out.println("nome richiesto non trovato");
            }
        }
        return (persona);
    }
}
