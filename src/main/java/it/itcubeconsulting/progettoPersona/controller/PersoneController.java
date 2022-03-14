package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.util.*;

public class PersoneController implements IpersonaController {

   private ArrayList<Persona> lista = new ArrayList<Persona>();



    @Override
    public void inserisci(Persona persona) {
        lista.add(persona);
        //System.out.println(lista);

    }

    @Override
    public List<Persona> visualizza() {

        Iterator<Persona> i = lista.iterator();
        if (lista.isEmpty()) {
            System.out.println("La lista e vuota,non ci sono persone da visualizzare");
        } else {
            while (i.hasNext()) {
                Persona p = i.next();
                System.out.println(p);
            }
        }
        return null;
    }

    @Override
    public boolean cancella(Persona persona) {

        boolean bool = false;
        String n = persona.getNome();
        String c = persona.getCognome();
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
