package it.itcubeconsulting.progettoPersona;

import it.itcubeconsulting.progettoPersona.controller.PersoneController;
import it.itcubeconsulting.progettoPersona.model.Persona;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        Scanner scan = new Scanner(System.in);

        PersoneController personeController = new PersoneController(lista, scan);
        inputUtente(lista, scan, personeController);

        personeController.toString();
    }

    // promt input che prende i param lista scanner e il personecontroller.
    private static void inputUtente(ArrayList lista, Scanner scan, PersoneController personeController) {

        int scelta;

        {
            do {
                System.out.println("1.INSERISCI");
                System.out.println("2.VISSUALIZZA");
                System.out.println("3.CANCELLA");
                System.out.println("4.MODIFICA");
                System.out.println("UN ALTRO NR PER USCIRE");
                System.out.println("--------------------------------");
                System.out.println("Inserisci la sua scelta :");
                scelta = scan.nextInt();
                String newLine = scan.nextLine();

                switch (scelta) {
                    case 1:
                        personeController.inserisci(lista, scan);
                        break;
                    case 2:
                        personeController.vissualizza(lista, scan);
                        break;

                    case 3:
                        personeController.cancella(lista, scan);
                        break;

                    case 4:
                        personeController.modifica(lista, scan);
                        break;
                }
            }
            while (scelta == 1 || scelta == 2 || scelta == 3 || scelta == 4);
        }
    }
}

