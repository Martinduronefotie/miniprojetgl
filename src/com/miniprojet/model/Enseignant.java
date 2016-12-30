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
public class Enseignant {
    
    private int  id_enseignant ;
    private String Mot_passe ;
    private String login ;
    
    /**
     *  constructeur pour construit un chanps
     * @param Mot_passe
     * @param login 
     */

    public Enseignant(String Mot_passe, String login) {
        this.Mot_passe = Mot_passe;
        this.login = login;
    }

    public Enseignant() {
    }
    
    

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public String getMot_passe() {
        return Mot_passe;
    }

    public void setMot_passe(String Mot_passe) {
        this.Mot_passe = Mot_passe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
            
    
}
