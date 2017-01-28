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
public class ModelEtudiants {
    
    private String idetudiants ;
    private Encadrement encadrement;
    private String nom;
    private String prenom;
    private Double note ;
    
    //info fronteint
    private String libelle;
    private String Type_encadrement;
    private String eta_encadrement ;

    public ModelEtudiants(String idetudiants, Encadrement encadrement, String nom, String prenom, Double note) {
        this.idetudiants = idetudiants;
        this.encadrement = encadrement;
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
        
        libelle= this.encadrement.getTheme().getLibelle();
        Type_encadrement= this.encadrement.getType_encadrement();
        eta_encadrement= this.encadrement.getEta_encadrement();
        
    }

    public String getLibelle() {
        return encadrement.getTheme().getLibelle();
        //return  "hhh";
    }

    public void setLibelle(String libelle) {
        this.libelle = encadrement.getTheme().getLibelle() ;
    }

    public String getType_encadrement() {
        return encadrement.getType_encadrement();
    }

    public void setType_encadrement(String Type_encadrement) {
        this.Type_encadrement = encadrement.getType_encadrement();
    }

    public String getEta_encadrement() {
        return encadrement.getEta_encadrement();
    }

    public void setEta_encadrement(String eta_encadrement) {
        this.eta_encadrement = encadrement.getEta_encadrement();
    }
    
    

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
 
   
    

    public ModelEtudiants() {
    }
    
    public String getIdetudiants() {
        return idetudiants;
    }

    public void setIdetudiants(String idetudiants) {
        this.idetudiants = idetudiants;
    }

    public Encadrement getEncadrement() {
        return encadrement;
    }

    public void setEncadrement(Encadrement encadrement) {
        this.encadrement = encadrement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
 
    
}
