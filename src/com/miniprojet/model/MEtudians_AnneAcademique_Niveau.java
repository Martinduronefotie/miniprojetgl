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
    
    private  ModelEtudiants etud ;
    private  ModelAnneAcademique acd;
    private  Niveau niv ;

    public MEtudians_AnneAcademique_Niveau(ModelEtudiants etud, ModelAnneAcademique acd, Niveau niv) {
        this.etud = etud;
        this.acd = acd;
        this.niv = niv;
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
