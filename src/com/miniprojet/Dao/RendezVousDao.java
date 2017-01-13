/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.Dao;

import com.miniprojet.model.Encadrement;
import com.miniprojet.model.Enseignant;
import com.miniprojet.model.Etudiants;
import com.miniprojet.model.RendezVous;
import com.miniprojet.model.Theme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class RendezVousDao extends Dao{
    
    private boolean reponse;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public RendezVousDao(){
        super();
    }
    
    /**
     * cette methode ajoute un rendez vous
     * @param rdv le rendez vous
     */
    public void ajouterRendezVous(RendezVous rdv){
        try{
             pst = super.getCon().prepareStatement("INSERT INTO rendez_vous VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, null);
            pst.setString(2,rdv.getEtudiant().getIdetudiants());
            pst.setString(3,rdv.getTemps());
            pst.setString(4, rdv.getDate());
            pst.setString(5, rdv.getHreAlert());
            pst.setString(6, rdv.getInformation());
            pst.setString(7, rdv.getProchainTravail());
            pst.executeUpdate();
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    }
    
    /**
     * cette methode supprime un rendez vous
     * @param idRdv id du rendez vous
     */
    public void deleteRendezVous(int idRdv){
         try {
            pst = super.getCon().prepareStatement("DELETE FROM rendez_vous WHERE id_rendez_vous = ?");
            pst.setInt(1, idRdv);
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * mise a jour d'un rendez vous
     * @param rdv un rendez vous
     */
    public void updateRendezVous(RendezVous rdv) {
        try {

            pst = super.getCon().prepareStatement("UPDATE rendez_vous SET etudiants_id_etudiants = ?,heure = ?,date = ?, heure_alert = ?, information = ?, prochain_travail = ? , WHERE id_rendez_vous = ?");
           
            pst.setString(1, rdv.getEtudiant().getIdetudiants());
            pst.setString(2, rdv.getTemps());
            pst.setString(3, rdv.getDate());
            pst.setString(4, rdv.getHreAlert());
            pst.setString(5, rdv.getInformation());
            pst.setString(6, rdv.getProchainTravail());
             pst.setInt(7, rdv.getId_rendezVous());
            
            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     /**
      * cette methode permet d'avoir la liste des rendez vous avec les etudiants
      * correspondant a chaque rendez vous
      * @return la liste des rendez vous
      */
    public ArrayList<RendezVous> AllRendezVous() {
        ArrayList<RendezVous> listRendezVous = new ArrayList<RendezVous>();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM rendez_vous,etudiants WHERE etudiants_id_etudiants = id_etudiants");
            rs = pst.executeQuery();
            while (rs.next()) {
               RendezVous rdv = new RendezVous();
               
                //recuperation des info sur l'etudiant
                Etudiants etd = new Etudiants();
                etd.setIdetudiants(rs.getString("id_etudiants"));
              

                 //infomartion sur le rendez vous
                rdv.setId_rendezVous(rs.getInt("id_rendez_vous"));
                rdv.setInformation(rs.getString("information"));
                rdv.setHreAlert(rs.getString("heure_alert"));
                rdv.setProchainTravail(rs.getString("prochain_travail"));
                rdv.setDate(rs.getString("date"));
                rdv.setEtudiant(etd);
                
                listRendezVous.add(rdv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRendezVous;
    }
    
}
