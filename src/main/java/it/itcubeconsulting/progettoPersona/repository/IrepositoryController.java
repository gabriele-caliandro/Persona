package it.itcubeconsulting.progettoPersona.repository;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IrepositoryController {

    //public void scriviFile(Persona persona);
//        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/it/itcubeconsulting/progettoPersona/constants/uploads/prova.txt", true));
//        String nome = persona.getNome();
//        String cognome = persona.getCognome();
//        bw.write(nome + " " + cognome);
//        bw.newLine();
//        bw.close();

    public boolean inserisciFile(Persona persona) throws IOException;

    public File leggiFile();

    public File modificaFile(Persona persona) throws IOException;

    public boolean cancellaFIle(Persona persona) throws IOException;

    public void spostaFIle(String filepath, String listaRimuovere);


}