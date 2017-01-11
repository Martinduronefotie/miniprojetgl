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

    public ModelEtudiants(String idetudiants, Encadrement encadrement, String nom, String prenom, Double note) {
        this.idetudiants = idetudiants;
        this.encadrement = encadrement;
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
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
