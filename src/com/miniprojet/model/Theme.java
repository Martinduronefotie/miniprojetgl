/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.model;

/**
 *
 * @author wilson black
 */
public class Theme {

    private int id;
    private String libelle;
    private String etat_theme;
    
    /**
     * constructeur de la classe theme
     * @param libelle (libelle du theme)
     * @param etat_theme(prend 2 valeures oui ou non) permet de savoir si le theme a deja ete utilise oui ou non
     */
    public Theme(String libelle, String etat_theme){
        this.libelle = libelle;
        this.etat_theme = etat_theme;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEtat_theme() {
        return etat_theme;
    }

    public void setEtat_theme(String etat_theme) {
        this.etat_theme = etat_theme;
    }
}
