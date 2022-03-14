package it.itcubeconsulting.progettoPersona.controller;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.util.List;

public interface IpersonaController {

    public void inserisci(Persona persona);

    public List<Persona> visualizza();

    public boolean cancella(Persona persona);

    public Persona modifica(Persona persona);
}
