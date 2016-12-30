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
public class Specialiter {
    
    private int id_specialiter ;
    private String Libelle ;
    
    /**
     * constructeur sans parametre 
     */

    public Specialiter() {
    }
    
    
    /**
     * constructeur avec parametre 
     * @param Libelle 
     */

    public Specialiter(String Libelle , int id ) {
        this.Libelle = Libelle;
        this.id_specialiter= id ;
    }
    
    public Specialiter(String Libelle  ) {
        this.Libelle = Libelle;
        
    }
    
    

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
    
    
    public int  getIdspecialiter() {
        return id_specialiter;
    }

    public void setIspecialiter(int id) {
        this.id_specialiter = id;
    }
    
    
    
}
