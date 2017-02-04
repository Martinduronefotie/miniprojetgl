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
public class MEtudians_AnneAcademique_Niveau {
    private  int id ;
    private  ModelEtudiants etud ;
    private  ModelAnneAcademique acd;
    private  Niveau niv ;
    
    private String matri;
    private String anneac ;
    private String niveau ;

    public MEtudians_AnneAcademique_Niveau(ModelEtudiants etud, ModelAnneAcademique acd, Niveau niv) {
      
        this.etud = etud;
        this.acd = acd;
        this.niv = niv;
        matri=this.etud.getIdetudiants();
        anneac=this.acd.getLibelle();
        niveau= this.niv.getLibelle();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatri() {
        return etud.getIdetudiants();
    }

    public void setMatri(String matri) {
        this.matri = etud.getIdetudiants();
    }

    public String getAnneac() {
        return acd.getLibelle();
    }

    public void setAnneac(String anneac) {
        this.anneac =acd.getLibelle();
    }

    public String getNiveau() {
        return niv.getLibelle();
    }

    public void setNiveau(String niveau) {
        this.niveau = niv.getLibelle();
    }
    
    

    public MEtudians_AnneAcademique_Niveau() {
    }

    public ModelEtudiants getEtud() {
        return etud;
    }

    public void setEtud(ModelEtudiants etud) {
        this.etud = etud;
    }

    public ModelAnneAcademique getAcd() {
        return acd;
    }

    public void setAcd(ModelAnneAcademique acd) {
        this.acd = acd;
    }

    public Niveau getNiv() {
        return niv;
    }

    public void setNiv(Niveau niv) {
        this.niv = niv;
    }
    
    
    
    
    
    
}
