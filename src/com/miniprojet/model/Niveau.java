/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.model;

/**
 *
 * @author durone
 */
public class Niveau {
    
    
    private int id_niveau;
    private String  libelle ;
    private Specialiter specialiter ;

    public Niveau( String libelle, Specialiter specialiter) {
        this.libelle = libelle;
        this.specialiter = specialiter;
    }
    

    public Niveau() {
    }
    
    
    

    public int getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(int id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Specialiter getSpecialiter() {
        return specialiter;
    }

    public void setSpecialiter(Specialiter specialiter) {
        this.specialiter = specialiter;
    }
    
}
