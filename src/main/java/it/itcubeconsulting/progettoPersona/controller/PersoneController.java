package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.*;
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

    @Override
    public void scriviFile(Persona persona) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/it/itcubeconsulting/progettoPersona/constants/uploads/prova.txt", true));
        String nome = persona.getNome();
        String cognome = persona.getCognome();
        bw.write(nome + " " + cognome);
        bw.newLine();
        bw.close();
    }

    @Override
    public void leggiFile() {

    }

    @Override
    public void modificaFile(Persona persona) {

    }

    @Override
    public void cancellaFile(Persona persona) throws IOException {

        File tempDB = new File("src/main/java/it/itcubeconsulting/progettoPersona/constants/uploads/tempDB.txt");
        File db = new File("src/main/java/it/itcubeconsulting/progettoPersona/constants/uploads/prova.txt");
        ListIterator<Persona> li = lista.listIterator();
        String nome = persona.getNome();
        String cognome = persona.getCognome();
        boolean b = false;

        //BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

        Iterator<Persona> i = lista.iterator();
        while (i.hasNext()) {
            Persona p = i.next();
            if (p.getNome().equals(nome) && (p.getCognome().equals(cognome))) {
                i.remove();
                b = true;
                bw.write(String.valueOf(li));
                bw.flush();
                bw.newLine();
            } else {
                System.out.println("nome richiesto non trovato");
            }
            b = false;
        }
        bw.close();

        db.delete();

        tempDB.renameTo(db);

    }
}
