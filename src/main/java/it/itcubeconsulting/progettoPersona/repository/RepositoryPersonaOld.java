//package it.itcubeconsulting.progettoPersona.repository;
//

//
//import java.io.IOException;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.io.File;
//
//public class RepositoryPersonaOld implements Serializable {
//
//    File file = new File("tempDb.txt");
//    private ArrayList<Persona> lista = new ArrayList<Persona>();
//
//    public FileWriter fw = new FileWriter("tempDb.txt", true);
//    public BufferedWriter bw = new BufferedWriter(fw);
//    public PrintWriter pw = new PrintWriter(bw);
//    public FileReader fr = new FileReader(file);
//    public BufferedReader br = new BufferedReader(fr);
//
//    ObjectOutputStream oos = null;
//    ObjectInputStream ois = null;
//
//    public RepositoryPersonaOld() throws IOException {
//    }
//
//
//    @Override
//    public void inserisciPersonaFile(Persona persona) throws IOException {
//        try {
//            if (file.exists()) {
//
//                fw.write(persona.getNome() + "," + persona.getCognome());
//
//                fw.close();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
////        if (file.exists()) {
////            lista.add(new Persona(persona.getNome(), persona.getCognome()));
////            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
////            oos.writeObject(lista);
////            oos.close();
////        } else {
////            System.out.println("Lista non trovata");
////        }
//
//    @Override
//    public List leggiPersonaFile() throws IOException, ClassNotFoundException {
//
//        try {
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String[] personaString = line.split(" ");
//                String nome = personaString[0];
//                String cognome = personaString[1];
//                Persona persona = new Persona(nome, cognome);
//                nuovaLista.add(persona);
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return file;
//
//
//        Scanner scanner = new Scanner(file);
//
//        while (scanner.hasNextLine()) {
//
//            String dataInfo = scanner.nextLine();
//
//            System.out.println(dataInfo);
//
//        }
//
//        scanner.close();
//
//    }
//
//            catch(
//    FileNotFoundException e)
//
//    {
//
//
//        e.printStackTrace();
//
//    }
//
//}
//
//    }
//
//            }
//
//@Override
//public boolean modificaPersonaFile(Persona persona)throws IOException{
//        if(file.isFile()){
//        Boolean found=false;
//        String li=String.valueOf(lista.listIterator());
//        while(li.hasNext())
//        Persona p=(Persona)li.next();
//        if(p.nome=persona.getNome()){
//
//        found=true;
//        }
//
//        return true;
//        }
//
//
//@Override
//public boolean cancellaPersonaFIle(Persona persona)throws IOException{
//        return false;
//        }
//
//@Override
//public void spostaFIle(String filepath,String listaRimuovere){
//
//        }
////
////    @Override
////    public File leggiPersonaFile() {
////        try {
////            Scanner scanner = new Scanner(file);
////            while (scanner.hasNextLine()) {
////                String nomeCognome = scanner.nextLine();
////                System.out.println(nomeCognome);
////            }
////            scanner.close();
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////        return file;
////    }
////
////
////    @Override
////    public File modificaPersonaFile(Persona persona) throws IOException {
////
////        BufferedReader reader = null;
////        ArrayList<String> lista = new ArrayList<>();
////        ListIterator<String> li = lista.listIterator();
////        String line = reader.readLine();
////
////
////        while (li.hasNext()) {
////            line = li.next();
////            String[] personaString = line.split(" ");
////            String nome = personaString[0];
////            String cognome = personaString[1];
////            for (Persona p : lista) {
////                if (p.getNome().equals(nome) && (p.getCognome().equals(cognome))) {
////                    li.set(new Persona(nome, cognome));
////
////                    Persona persona = new Persona(nome, cognome);
////
////                    while (line != null) {
////                        line = reader.readLine();
////                        lista.add(line);
////                        while (li.hasNext()) {
////                            String li = li.next();
////                            if (p.getNome().equals(nome) && (p.getCognome().equals(cognome))) {
////                                li.set(p.);
////                                // System.out.println("Inserisci il nuovo nome cognome...");
////                                //String newContent = oldContent.replaceAll(oldString, newString);
////                            }
////
////                            return file;
////                        }
//
//@Override
//public boolean cancellaPersonaFIle(Persona persona)throws IOException{
//
//        }
//
//@Override
//public void spostaFIle(String filepath,String listaRimuovere){
//
//        }
//
//public void File leggiFile(){
//
//        try{
//        Scanner myReader=new Scanner(file);
//        while(myReader.hasNextLine()){
//        String data=myReader.nextLine();
//        System.out.println(data);
//        }
//        myReader.close();
//        }catch(FileNotFoundException e){
//        e.printStackTrace();
//        }
//        return file;
//        }
//
//
////    @Override
////    //ricevo nome cognome input
////    //return nuova list modificata
////    public File modificaFile(Persona persona) throws IOException {
////
////        //leggi tutti nomi del file
////        //inserisci in una arraylist
////        //modifico il nome che ho bisogno
////        //reinserico nel file l arraylist con il nome modificato.
////        BufferedReader reader = null;
////        ArrayList<String> lista = new ArrayList<>();
////        ListIterator<String> li = lista.listIterator();
////        String line = reader.readLine();
////        String nome = persona.getNome();
////        String cognome = persona.getNome();
//////
////            String[] personaString = line.split(" ");
////            String nome = personaString[0];
////            String cognome = personaString[1];
////            Persona persona = new Persona(nome, cognome);
////            nuovaLista.add(persona);
////
////        while (line != null) {
////            line = reader.readLine();
////            lista.add(line);
////            while (li.hasNext()) {
////                String li = li.next();
////                if (p.getNome().equals(nome) && (p.getCognome().equals(cognome))) {
////                    li.set(p.);
////                    // System.out.println("Inserisci il nuovo nome cognome...");
////                    //String newContent = oldContent.replaceAll(oldString, newString);
////                }
////
////                return file;
////            }
//
////
////            @Override
////            //ricevo nome cognome input, return output list senza nome cogome ricevuto
////            public boolean cancellaFIle (Persona persona) throws IOException {
////                boolean b = false;
////                Scanner sc = new Scanner(file);
////                String line = sc.nextLine();
////                String filepath = file.getPath();
////                String nomeDaRimuovere = persona.getNome();
////                while (sc.hasNextLine()) {
////                    if (line.contentEquals(nomeDaRimuovere)) {
////                        spostaFIle(filepath, nomeDaRimuovere);
////                        b = true;
////                    } else {
////                        b = false;
////                    }
////                    return b;
////                    sc.close();
////                }
////
////                @Override
////                public void spostaFIle (String filepath, String nomeDaRimuovere){
////                    String tempfile = "tempDb.txt";
////                    File oldFile = new File(filepath);
////                    File newFile = new File(tempfile);
////                    String nome = "";
////                    String cognome = "";
////                    Scanner sc = new Scanner((Readable) System.out);
////
////                    try {
////                        fw = new FileWriter(tempfile, true);
////                        bw = new BufferedWriter(fw);
////                        pw = new PrintWriter(bw);
////                        sc = new Scanner(new File(filepath));
////                        sc.useDelimiter(("[,\n]"));
////                        while (sc.hasNext()) ;
////                        {
////                            String name = sc.next();
////                            String surname = sc.next();
////
////                            if (!name.equals(nomeDaRimuovere)) {
////                                pw.println(name, surname);
////                            }
////                        }
////                        sc.close();
////                        pw.flush();
////                        pw.close();
////                        oldFile.delete();
////                        File dump = new File(filepath);
////                        newFile.renameTo(dump);
////
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////
////            @Override
////            public void spostaFIle (String filepath, String listaRimuovere){
////                String tempfile = "tempDb.txt";
////                File oldFile = new File(filepath);
////                File newFile = new File(tempfile);
////                String nome = "";
////                String cognome = "";
////                Scanner sc = new Scanner((Readable) System.out);
////
////            }
////                    }}}}}
////
////    @Override
////    public boolean cancellaPersonaFIle(Persona persona) throws IOException {
////        return false;
////    }
////
////    @Override
////    public void spostaFIle(String filepath, String listaRimuovere) {
////
//        }
//        }
