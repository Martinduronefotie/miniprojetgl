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
public class Encadrement {
    private int id_encadremet;
    private  Theme theme ;
    private  String thdata;
    private  Enseignant enseignant ;
    private String Type_encadrement ;
    private String eta_encadrement ;
    private int  idthemes ;

    public Encadrement(Theme theme, Enseignant enseignant, String Type_encadrement, String eta_encadrement) {
        this.theme = theme;
        this.thdata= theme.getLibelle();
        this.idthemes=theme.getId();
        
        this.enseignant = enseignant;
        this.Type_encadrement = Type_encadrement;
        this.eta_encadrement = eta_encadrement;
    }

    public Encadrement() {
    }

    public int getId_encadremet() {
        return id_encadremet;
    }

    public void setId_encadremet(int id_encadremet) {
        this.id_encadremet = id_encadremet;
    }

    public Theme getTheme() {
       return theme;
    }

    public String getThdata() {
        return theme.getLibelle();
    }
    
    

    public void setTheme(Theme theme) {
        this.theme = theme;
        thdata=theme.getLibelle();
        idthemes = theme.getId();
    }

    public int getIdthemes() {
        return theme.getId();
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getType_encadrement() {
        return Type_encadrement;
    }

    public void setType_encadrement(String Type_encadrement) {
        this.Type_encadrement = Type_encadrement;
    }

    public String getEta_encadrement() {
        return eta_encadrement;
    }

    public void setEta_encadrement(String eta_encadrement) {
        this.eta_encadrement = eta_encadrement;
    }
    
    
    
    
    
    
}
