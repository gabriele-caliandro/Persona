package it.itcubeconsulting.progettoPersona.model;

import java.util.UUID;

import java.io.Serializable;

public class Persona {

    private String nome;
    private String cognome;



    public Persona(String nome, String cognome) {
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

    public String toString() {
        return nome + " " + cognome;

    }

}