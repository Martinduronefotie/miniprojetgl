/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.model;

import static java.sql.JDBCType.TIME;
import static java.util.Calendar.DATE;

/**
 *
 * @author william
 */
public class RendezVous {
    
    private int id_rendezVous;
    private String information;
    private String prochainTravail;
    private String temps;
    private String date;
    private String hreAlert;
    private ModelEtudiants etudiant;

    public RendezVous(String information, String prochainTravail, String temps, String date, String hreAlert, ModelEtudiants etudiant) {
        this.information = information;
        this.prochainTravail = prochainTravail;
        this.temps = temps;
        this.date = date;
        this.hreAlert = hreAlert;
        this.etudiant = etudiant;
    }

    public RendezVous() {};

    public int getId_rendezVous() {
        return id_rendezVous;
    }

    public void setId_rendezVous(int id_rendezVous) {
        this.id_rendezVous = id_rendezVous;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getProchainTravail() {
        return prochainTravail;
    }

    public void setProchainTravail(String prochainTravail) {
        this.prochainTravail = prochainTravail;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHreAlert() {
        return hreAlert;
    }

    public void setHreAlert(String hreAlert) {
        this.hreAlert = hreAlert;
    }

    public ModelEtudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(ModelEtudiants etudiant) {
        this.etudiant = etudiant;
    }
    
    
}
