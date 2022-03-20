package it.itcubeconsulting.progettoPersona.model;

import javax.swing.text.Utilities;
import java.util.Date;
import java.util.UUID;

public class Persona {

    //private  String id = String.valueOf(new Date().getTime());
    private String nome;
    private String cognome;
    private int id;


    public Persona(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + "," + nome + "," + cognome + "|";

    }
}
