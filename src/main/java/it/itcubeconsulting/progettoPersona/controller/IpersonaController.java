package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IpersonaController {

    public void inserisci(Persona persona);

    public List<Persona> visualizza();

    public boolean cancella(Persona persona);

    public Persona modifica(Persona persona);

    public void scriviFile(Persona persona) throws IOException;
    public void leggiFile();
    public void modificaFile(Persona persona);
    public void cancellaFile(Persona persona) throws IOException;
}
