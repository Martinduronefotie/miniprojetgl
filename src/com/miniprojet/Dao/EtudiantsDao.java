/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.Encadrement;
import com.miniprojet.model.ModelEtudiants;
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
public class EtudiantsDao extends Dao{
    
    public  EtudiantsDao(){
        super();
    }
    
    private boolean reponse;
    
    private ResultSet rs;
    private PreparedStatement pst;
    
     /**
     * cette methode permet d'ajouter un etudiants dans la bd
     *@param etd (elle represente un etudiants )
     */
    public void ajouterETudiants(ModelEtudiants etd) {
              
        try {
            
            pst= super.getCon().prepareStatement("INSERT INTO conpteur VALUES(?) ");
            pst.setInt(1,0);
            pst.executeUpdate();
            
             pst = super.getCon().prepareStatement("SELECT * FROM conpteur");
             rs = pst.executeQuery();
             int i = 0;
             while (rs.next()){
                 i= rs.getInt("conpteurid");   
            }
            
            
           
            try {
                etd.setIdetudiants("iut"+String.valueOf(etd.hashCode())+""+String.valueOf(i));
                pst = super.getCon().prepareStatement("INSERT INTO etudiants VALUES(?,?,?,?,?)");
                pst.setString(1, etd.getIdetudiants());
                pst.setInt(2,etd.getEncadrement().getId_encadremet());
                pst.setString(3,etd.getNom());
                pst.setString(4, etd.getPrenom());
                pst.setInt(5,0);
                pst.executeUpdate();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    /**
     * suppression d'un etudiants
     *
     * @param id (identifiant de l etudiants )
     */
    public void deleteEtd(String id) {
        try {
            pst = super.getCon().prepareStatement("DELETE FROM etudiants WHERE id_etudiants = ?");
            pst.setString(1,id);
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     /**
     * mise a jour d'un etudiants
     *
     * @param  etd ( representer l'etudiants a metre a jour )
     */
    public void updateEtd(ModelEtudiants etd) {
        try {

            pst = super.getCon().prepareStatement("UPDATE etudiants SET encadrement_id_encadrement = ?,nom = ?, prenom = ? note = ? WHERE id_etudiants = ?");
            

            pst.setInt(1,etd.getEncadrement().getId_encadremet());
            pst.setString(2,etd.getNom());
            pst.setString(3,etd.getPrenom());
            pst.setDouble(4,etd.getNote());
            pst.setString(5,etd.getIdetudiants());

            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * cette methode permet de recupere un etudiants par son identifiant
     *
     * @param id(represent l identifaint de l'etudiants)
     * @return etudiants
     */
    public ModelEtudiants recupUnEtudiants(String id ) {

       ModelEtudiants etd = new ModelEtudiants();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM etudiants where id_etudiants=?");
            pst.setString(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
                //recuperation des info sur un encadrement
                
                EncadrementDao ecdao = new EncadrementDao();
                Encadrement ecard = ecdao.recupUnEncadrement(rs.getInt("encadrement_id_encadrement"));
                
                //recupration des info sur un etudiants

                etd.setEncadrement(ecard);
                etd.setIdetudiants(rs.getString("id_etudiants"));
                etd.setNom(rs.getString("nom"));
                etd.setPrenom("prenom");
                etd.setNote(rs.getDouble("note"));
               

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return etd;
    }
    
     /**
     * cette methode permet de recupere la liste des  etudiants 
     * @return une liste d etudiants
     */
    
    public List<ModelEtudiants> recupAllEtudiants() {

      List<ModelEtudiants> listetd = new ArrayList<ModelEtudiants>();
       EncadrementDao ecdao = new EncadrementDao();
      
      try {
            pst = super.getCon().prepareStatement("SELECT * FROM etudiants");
            rs = pst.executeQuery();
            while (rs.next()) {
                
                ModelEtudiants etd = new ModelEtudiants();
                //recuperation des info sur un encadrement
                
               
                 Encadrement ecard = ecdao.recupUnEncadrement(rs.getInt("encadrement_id_encadrement"));
                
                //recupration des info sur un etudiants

                etd.setEncadrement(ecard);
                etd.setIdetudiants(rs.getString("id_etudiants"));
                etd.setNom(rs.getString("nom"));
                etd.setPrenom("prenom");
                etd.setNote(rs.getDouble("note"));
                
                listetd.add(etd);
               

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listetd;
    }
   
}
