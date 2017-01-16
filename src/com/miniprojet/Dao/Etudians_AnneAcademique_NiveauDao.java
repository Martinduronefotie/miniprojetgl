/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.Encadrement;
import com.miniprojet.model.MEtudians_AnneAcademique_Niveau;
import com.miniprojet.model.ModelAnneAcademique;
import com.miniprojet.model.ModelEtudiants;
import com.miniprojet.model.Niveau;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author durone
 */
public class Etudians_AnneAcademique_NiveauDao extends Dao{
    
     private boolean reponse;
    
    private ResultSet rs;
    private PreparedStatement pst;
    
    /**
     * cette fonction permet de sauvegarder MEtudians_AnneAcademique_Niveau
     * @param ean (represention dn un MEtudians_AnneAcademique_Niveau )
     */
    public  void saveEtAnnN(MEtudians_AnneAcademique_Niveau ean){
        
        try {

            pst = super.getCon().prepareStatement("INSERT INTO etudiants_has_anne_academiques VALUES(?,?,?)");
            pst.setString(1, ean.getEtud().getIdetudiants());
            pst.setInt(2,ean.getAcd().getId_anne_accademiques());
            pst.setInt(3,ean.getNiv().getId_niveau());
            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    /**
     * cette methode permet de faire une supression sur un etudiant pour l année academique
     * @param id (represente le matricule de l' etudiants)
     * return aucune valeu
     */
    public  void deleteEtAnnN(String id){
        
         try {
             pst = super.getCon().prepareStatement("delete  from etudiants_has_anne_academiques where etudiants_id_etudiants =?");
             pst.setString(1, id);
             pst.executeUpdate();

         
         } catch (SQLException ex) {
             Logger.getLogger(Etudians_AnneAcademique_NiveauDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
    public void misajourEAN(MEtudians_AnneAcademique_Niveau ean){
        try {

            pst = super.getCon().prepareStatement("UPDATE etudiants_has_anne_academiques SET anne_academiques_id_annee_academiques = ?,niveau_id_niveau = ?  WHERE etudiants_id_etudiants = ?");
            

            pst.setInt(1,ean.getAcd().getId_anne_accademiques());
            pst.setInt(2,ean.getNiv().getId_niveau());
           

            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
    
     /**
     * cette methode permet de recupere la liste des annes academiques 
     * @return une liste d etudiants
     */
    
    public List<MEtudians_AnneAcademique_Niveau> recupUnEtudiants() {

      List<MEtudians_AnneAcademique_Niveau> listena = new ArrayList<MEtudians_AnneAcademique_Niveau>();
      EtudiantsDao daoEd = new  EtudiantsDao();
      NiveauDao ndao = new NiveauDao();
      AnneAcademiqueDao ancdao =new AnneAcademiqueDao();
      
      try {
            pst = super.getCon().prepareStatement("SELECT * FROM etudiants_has_anne_academiques");
            rs = pst.executeQuery();
            while (rs.next()) {
                
                //recupération d une année academiques
                 ModelEtudiants etd = daoEd.recupUnEtudiants(rs.getString("etudiants_id_etudiants"));
                //recupération tu niveau
                 Niveau niv = ndao.recupereUnNiveau(rs.getInt("niveau_id_niveau"));
                //recuperation des info sur un encadrement
               
                //recupration des info années academiques 
                 
                 ModelAnneAcademique annc=ancdao.recuperUneAnneAcademique(rs.getInt("anne_academiques_id_annee_academiques"));
                 MEtudians_AnneAcademique_Niveau Ean = new MEtudians_AnneAcademique_Niveau(etd, annc, niv);
                 listena.add(Ean);  

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listena;
    }
    
    
    
    
}
