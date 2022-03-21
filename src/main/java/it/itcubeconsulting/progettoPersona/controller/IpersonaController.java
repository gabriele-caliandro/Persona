package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.IOException;
import java.util.List;

public interface IpersonaController {

    void inserisci(Persona persona) throws IOException, ClassNotFoundException;

    List<Persona> visualizza() throws IOException, ClassNotFoundException;

    boolean cancella(int id) throws IOException;

    boolean modifica(int id);
//
//    public void inserisci(Persona persona) throws IOException, ClassNotFoundException;
//
//    public List<Persona> visualizza() throws IOException, ClassNotFoundException;
//
//    public boolean cancella(Persona persona) throws IOException;
//
//    public Persona modifica(Persona persona);


}
