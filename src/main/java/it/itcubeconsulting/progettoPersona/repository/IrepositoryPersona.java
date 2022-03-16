package it.itcubeconsulting.progettoPersona.repository;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IrepositoryPersona {


    public void inserisciPersonaFile(Persona persona) throws IOException, ClassNotFoundException;


    public List<Persona> leggiPersonaFile() throws IOException, ClassNotFoundException;


    public Persona modificaPersonaFile(Persona persona) throws IOException;


    public boolean cancellaPersonaFIle(Persona persona) throws IOException;


}