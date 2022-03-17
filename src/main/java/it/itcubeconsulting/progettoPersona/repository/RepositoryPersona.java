package it.itcubeconsulting.progettoPersona.repository;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryPersona implements IrepositoryPersona, Serializable {


    File file = new File("src\\main\\resources\\tempDb.txt");
    String filename = "src\\main\\resources\\tempDb.txt";
    private ArrayList<Persona> lista = new ArrayList<Persona>();
    //public FileReader fr = new FileReader(file);

    public RepositoryPersona() throws IOException {
    }


    @Override
    public void inserisciPersonaFile(Persona persona) throws IOException, ClassNotFoundException {
        FileWriter fw = new FileWriter(file, true);

        try {
            fw.append(persona.getNome()).append(",").append(persona.getCognome()).append("|");
            fw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        lista.add(persona);
        System.out.println("La lista e " + lista);
    }


    @Override
    public List<Persona> leggiPersonaFile() throws IOException, ClassNotFoundException {
        List<Persona> personaList = new ArrayList<>();
        Path fileName = Path.of("src\\main\\resources\\tempDb.txt");
        String dataString = Files.readString(fileName);
        //nome , cognome|n1 , c1 | n2, c2...|
        String[] data = dataString.split("\\|");
        for (String personaString : data) {
            // {nome , cognome}

            String[] nomeCognome = personaString.split(",");
            String nome = nomeCognome[0];
            String cognome = nomeCognome[1];
            personaList.add(new Persona(nome, cognome));
            System.out.println(nome + " " + cognome);
        }

        return personaList;
    }

    @Override
    public Persona modificaPersonaFile(Persona persona) throws IOException {
        Persona newPersona = new Persona("", "");

        String oldName = "oLD NAME";
        String oldSurname = "OLD SURNAME";
        for (int i = 0; i < lista.size(); i++) {
            Persona persona1 = lista.get(i);
            if (persona1.getNome().equals(oldName) && persona1.getCognome().equals(oldSurname)) {
                persona1.setNome(persona.getNome());
                persona1.setCognome(persona.getCognome());
                newPersona.setNome(persona.getNome());
                newPersona.setCognome(persona.getCognome());

                lista.set(i, persona1);

                break;  // for loop
            }
        }

        Path path = Path.of(filename);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            System.err.println(x);
        }

        FileWriter fw = new FileWriter(filename);
        try {
            for (Persona persona1 : lista) {
                fw.write(persona1.getNome() + "," + persona1.getCognome() + "|");
            }

            fw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return newPersona;
    }

    @Override
    public boolean cancellaPersonaFIle(Persona persona) throws IOException {

        for (int i = 0; i < lista.size(); i++) {
            Persona persona1 = lista.get(i);
            if (persona1.getNome().equals(persona.getNome()) && persona1.getCognome().equals(persona.getCognome())) {
                lista.remove(i);

                break;  // for loop
            }
        }

        Path path = Path.of(filename);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }

        FileWriter fw = new FileWriter(filename);
        try {
            for (Persona persona1 : lista) {
                fw.write(persona1.getNome() + "," + persona1.getCognome() + "|");
            }

            fw.close();

        } catch (IOException ex) {
            ex.printStackTrace();

            return false;
        }

        return true;
    }
}
