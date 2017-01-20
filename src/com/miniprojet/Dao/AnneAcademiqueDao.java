/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.ModelAnneAcademique;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author durone
 */
public class AnneAcademiqueDao extends Dao{
    
      private boolean reponse;

    private ResultSet rs;
    private PreparedStatement pst;
    
    public AnneAcademiqueDao(){
        super();
    }
    
     /**
     * cette methode permet d'ajouter une année academique dans la bd
     * @param ann (representer le niveau)
     */
    public void ajouteAnneAcd(ModelAnneAcademique ann){
    
        try{
           
            pst = super.getCon().prepareStatement("INSERT INTO anne_academiques VALUES(?,?)");
            pst.setInt(1, 0);
            pst.setString(2,ann.getLibelle());
            pst.executeUpdate(); 
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
   
    }
    
    /**
     * suppression d'une annéé academique
     * @param id (id de l année academique)
     */
    public void deleteAnneAcd(int id){
        try{
            pst = super.getCon().prepareStatement("DELETE FROM anne_academiques WHERE id_annee_academiques = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     /**
     * mise a jour d'une niveau
     * @param ann ( representer la specialiter a metre a jour ) 
     */
    public void updateniveau(ModelAnneAcademique ann ){
        try{
            
            pst = super.getCon().prepareStatement("UPDATE anne_academiques SET libelle = ? WHERE id_annee_academiques = ?");
            pst.setString(1, ann.getLibelle());
            pst.setInt(2,ann.getId_anne_accademiques());
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    // 
    
    /**
     * cette fonction recuperation de la liste des années acdemiques
     * @return  List<ModelAnneAcademique> des années academiques 
     */
      public List<ModelAnneAcademique> Allniveau(){
        List<ModelAnneAcademique> listniveau = new ArrayList<ModelAnneAcademique>();
        
        try{
            Statement st = super.getCon().createStatement();
            rs = st.executeQuery("SELECT * FROM anne_academiques ");
            
            while(rs.next()){
                int id = rs.getInt("id_annee_academiques");
                String libelle  = rs.getString("libelle");
                ModelAnneAcademique mode = new ModelAnneAcademique(id,libelle);
                listniveau.add(mode);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return listniveau;
    }
      /**
       * cette methpode recupere une annes academiques 
       * @param id
       * @return ModelAnneAcademique
       */
      public ModelAnneAcademique  recuperUneAnneAcademique(int id ) {
           ModelAnneAcademique Anc = new ModelAnneAcademique();
           try {

            pst = super.getCon().prepareStatement("SELECT * FROM anne_academiques where id_annee_academiques=?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                Anc.setLibelle(rs.getString("libelle"));
                 Anc.setId_anne_accademiques(id);
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
          return Anc ;
      }
    
    
    
}
