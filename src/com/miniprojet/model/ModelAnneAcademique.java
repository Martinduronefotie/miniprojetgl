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
public class ModelAnneAcademique {
    
    private int id_anne_accademiques;
    private String libelle ;

    public ModelAnneAcademique(String libelle) {
        
        this.libelle = libelle;
    }
    
     public ModelAnneAcademique( int id_anne_accademiques,String libelle) {
        this.id_anne_accademiques = id_anne_accademiques;
        this.libelle = libelle;
    }
    
    public ModelAnneAcademique() {
    }

    public int getId_anne_accademiques() {
        return id_anne_accademiques;
    }

    public void setId_anne_accademiques(int id_anne_accademiques) {
        this.id_anne_accademiques = id_anne_accademiques;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
  
    
}
