package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IpersonaController {

    public void inserisci(Persona persona) throws IOException, ClassNotFoundException;

    public List<Persona> visualizza() throws IOException, ClassNotFoundException;

    public boolean cancella(Persona persona) throws IOException;

    public Persona modifica(Persona persona);


}
