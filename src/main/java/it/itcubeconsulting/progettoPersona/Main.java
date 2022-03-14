package it.itcubeconsulting.progettoPersona;

import it.itcubeconsulting.progettoPersona.controller.PersoneController;
import it.itcubeconsulting.progettoPersona.model.Persona;

import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Ardit Shalla\\Documents\\JAVA\\prova-copy.txt"));
//            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ardit Shalla\\Documents\\JAVA\\prova.txt"));
//                bw.write("Ciaooo\n");
//                bw.write(" ");
//                bw.write("scrittura writer \n");
//                String s;
//                while ((s = br.readLine()) !=null){
//                    bw.write(s + "\n");
//                }
//                bw.close();
//                br.close();
//             } catch (Exception e){
//            return;
//    }
        File file = new File("src/repo/uploads/file.txt");
        if (file.exists()){
            System.out.println("Il file esiste");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            file.delete();
        }else{
            System.out.println("il file non esiste");

            Persona p1 = new Persona("A","S");
            Persona p2 = new Persona("B","C");
            Persona p3 = new Persona("D","E");
            ArrayList<Persona> al = new ArrayList<Persona>();
            al.add(p1);
            al.add(p2);
            al.add(p3);

            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;

            if (file.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file));
                al = (ArrayList<Persona>)ois.readObject();
                ois.close();
                System.out.println("-----------1-------------");
                System.out.println(al);

                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(al);
                oos.close();

                System.out.println("-----------2------------");
                System.out.println(al);

                
            }



        }



        Scanner scan = new Scanner(System.in);
        PersoneController personac = new PersoneController();

        int scelta;
        do {
            System.out.println("1.INSERISCI");
            System.out.println("2.VISSUALIZZA");
            System.out.println("3.CANCELLA");
            System.out.println("4.MODIFICA");
            System.out.println("UN ALTRO NR PER USCIRE");
            System.out.println("--------------------------------");
            System.out.println("Inserisci la sua scelta :");
            // scelta = scan.nextInt();
            scelta = scan.nextInt();


            /////////////

            switch (scelta) {

                case 1://INSERISCI
                    System.out.println("Inserisi il nome");
                    String nome = scan.next();

                    System.out.println("Inserisi il cognome");
                    String cognome = scan.next();

                    personac.inserisci(new Persona(nome, cognome));


                    break;
                case 2://VISSUALIZZA
                    personac.visualizza();

                    break;

                case 3://CANCELLA
                    System.out.println("Inserisci il nome da cancellare.");
                    String nome1 = scan.next();
                    System.out.println("Inserisi il cognome");
                    String cognome1 = scan.next();

                    personac.cancella(new Persona(nome1,cognome1));

                    break;

                case 4://MODIFICA
                    System.out.println("Inserisci il nome da modificare.");
                    String nome2 = scan.next();
                    System.out.println("Inserisi il cognome");
                    String cognome2 = scan.next();

                    personac.modifica(new Persona(nome2,cognome2));
                    break;
            }
        }
        while (scelta == 1 || scelta == 2 || scelta == 3 || scelta == 4);
    }
}

