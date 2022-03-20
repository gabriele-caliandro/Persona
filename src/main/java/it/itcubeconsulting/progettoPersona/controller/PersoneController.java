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
        Persona personaToFile = new Persona(persona.getId(), persona.getNome(), persona.getCognome());

        repositoyController.inserisciPersonaFile(personaToFile);

        lista.add(persona);
    }

    @Override
    public List<Persona> visualizza() throws IOException, ClassNotFoundException {

        Iterator<Persona> i = lista.iterator();
        if (lista.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println("LISTA VUOTA");
            System.out.println("----------------------------------------------------");
        } else {
            while (i.hasNext()) {
                Persona p = i.next();
                System.out.println(p);
            }
        }
        repositoyController.leggiPersonaFile();
        return null;
    }

    @Override
    public boolean cancella(int idCancellare) throws IOException {

        boolean bool = false;
        Iterator<Persona> i = lista.iterator();
        while (i.hasNext()) {
            Persona p = i.next();
            if (p.getId() == idCancellare) {
                i.remove();
                bool = true;
                // repositoyController.cancellaPersonaFIle(new Persona(n, c));
                System.out.println("ID " + idCancellare + " INSERITO, CANCELLATO CON SUCCESSO");
            } else {
                bool = false;
            }
        }

        return bool;
    }

    @Override
    public boolean modifica(int idModificare) {
        boolean bool = false;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < lista.size(); i++) {
            Persona persona1 = lista.get(i);
            if (persona1.getId() == (idModificare)) {
                System.out.println("INSERISCI IL NOVO NOME: ");
                String nome1 = scan.next();
                System.out.println("INSERISCI IL NUOVO COGNOME: ");
                String cognome1 = scan.next();
                persona1.setNome(nome1);
                persona1.setCognome(cognome1);
                lista.set(i, persona1);
                System.out.println("ID  " + idModificare + "  " + nome1 + " " + cognome1 + " " + "MODIFICATO CORRETTAMENTE");
                bool = true;
            } else {
                bool = false;
            }
        }
        return bool;
    }

}
