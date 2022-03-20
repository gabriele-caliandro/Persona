package it.itcubeconsulting.progettoPersona.repository;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryPersona implements IrepositoryPersona, Serializable {

    File file = new File("classpath: ./tempDb.txt");
    private Path path;
    List<String> lines = Files.readAllLines(path);
    String filename = "classpath: ./tempDb.txt";
    private ArrayList<Persona> lista = new ArrayList<Persona>();
    //String file = ".\\src\\main\\resources\\tempDb.txt";
    public FileWriter fw = new FileWriter(file, true);
    public BufferedWriter bw = new BufferedWriter(fw);

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
        Path fileName = Path.of("classpath: ./tempDb.txt");
        String dataString = Files.readString(fileName);
        //nome , cognome|n1 , c1 | n2, c2...|
        String[] data = dataString.split("\\|");
        for (String personaString : data) {

            if (personaString.isEmpty())
                break;
            // {nome , cognome}

            String[] idNomeCognome = personaString.split(",");
            int id = Integer.parseInt(idNomeCognome[0]);
            String nome = idNomeCognome[1];
            String cognome = idNomeCognome[2];
            personaList.add(new Persona(id, nome, cognome));
            System.out.println(id + "-" + nome + " " + cognome);
        }

        return personaList;
    }

    @Override
    public Persona modificaPersonaFile(Persona persona) throws IOException {
        Persona newPersona = new Persona(persona.getId(), "", "");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < lista.size(); i++) {
            Persona persona1 = lista.get(i);
            if (persona1.getId() == persona.getId()) {
                System.out.println("INSERISCI IL NOVO NOME: ");
                String nome1 = scan.next();
                System.out.println("INSERISCI IL NUOVO COGNOME: ");
                String cognome1 = scan.next();

                persona1.setId(persona.getId());
                persona1.setNome(nome1);
                persona1.setCognome(cognome1);
                newPersona.setNome(nome1);
                newPersona.setCognome(cognome1);
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
                fw.write(persona1.getId() + "-" + persona1.getNome() + "," + persona1.getCognome() + "|");
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
            if (persona1.getId() == (persona.getId())) {
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
                fw.write(persona1.getId() + "-" + persona1.getNome() + "," + persona1.getCognome() + "|");
            }
            fw.close();

        } catch (IOException ex) {
            ex.printStackTrace();

            return false;
        }

        return true;
    }
}
