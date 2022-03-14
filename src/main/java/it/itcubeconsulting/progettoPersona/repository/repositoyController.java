package it.itcubeconsulting.progettoPersona.repository;

import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.io.*;
import java.util.Scanner;

import static jdk.javadoc.internal.doclets.toolkit.util.StandardDocFileFactory.newFile;


public class repositoyController implements IrepositoryController {

    final File file = new File("tempDb.txt");

    public FileWriter fw = new FileWriter("tempDb.txt", true);
    public BufferedWriter bw = new BufferedWriter(fw);
    public PrintWriter pw = new PrintWriter(bw);
    public FileReader fr = new FileReader(file);
    public BufferedReader br = new BufferedReader(fr);


    public repositoyController() throws IOException {

    }


    @Override
    //ricevo nome cognome intput,
    // aggiorno lista e boolean di return true a buon fine.
    public boolean inserisciFile(Persona persona) throws IOException {
        if (file.exists()) {
            String nome = persona.getNome();
            String cognome = persona.getNome();
            fw = new FileWriter("tempDb.txt", true);
            bw = new BufferedWriter(fw);
            //pw = new PrintWriter(bw);
            try {
                bw.write(nome + " " + cognome);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {
            FileWriter fw = new FileWriter(file);
        }

        return true;
    }

    @Override

    public File leggiFile() {

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }


    @Override
    //ricevo nome cognome input
    //return nuova list modificata
    public File modificaFile(Persona persona) throws IOException {

        BufferedReader reader = null;
        assert false;
        String line = reader.readLine();
        String nome = persona.getNome();
        String cognome = persona.getNome();

        while (line != null) {
            String oldContent = nome + cognome + line + System.lineSeparator();
            line = reader.readLine();
           // System.out.println("Inserisci il nuovo nome cognome...");
            //String newContent = oldContent.replaceAll(oldString, newString);
        }

        return file;

    }


    @Override
    //ricevo nome cognome input, return output list senza nome cogome ricevuto
    public boolean cancellaFIle(Persona persona) throws IOException {
        Scanner sc = new Scanner(file);
        String filepath = file.getPath();
        String nomeDaRimuovere = persona.getNome();


            spostaFIle(filepath, nomeDaRimuovere);

        return false;
    }

    @Override
    public void spostaFIle(String filepath, String nomeDaRimuovere) {

        String tempfile = "tempDb.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempfile);
        String nome = "";
        String cognome = "";
        Scanner sc = new Scanner((Readable) System.out);

        try{
            fw = new FileWriter(tempfile, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            sc = new Scanner(new File(filepath));
            sc.useDelimiter(("[,\n]"));
            while (sc.hasNext());{
              String  name = sc.next();
              String  surname = sc.next();

              if (!name.equals(nomeDaRimuovere)){
                  pw.println(name, surname);
              }
            }
            sc.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}