/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.Niveau;
import com.miniprojet.model.Specialiter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author durone
 */
public class NiveauDao extends Dao{
    
    private boolean reponse;

    private ResultSet rs;
    private PreparedStatement pst;
    
    public NiveauDao(){
        super();
    }
    
      /**
     * cette methode permet d'ajouter une niveau dans la bd
     * @param niv (representer le niveau)
     */
    public void ajouterniveau(Niveau niv){
    
        try{
           
            pst = super.getCon().prepareStatement("INSERT INTO niveau VALUES(?,?)");
           
            pst.setInt(1,niv.getSpecialiter().getIdspecialiter());
            pst.setString(2,niv.getLibelle()); 
           
            pst.executeUpdate(); 
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
   
    }
    
     /**
     * suppression d'un niveau
     * @param id (id du niveau)
     */
    public void deleteniveau(int id){
        try{
            pst = super.getCon().prepareStatement("DELETE FROM niveau WHERE id_niveau = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     /**
     * mise a jour d'une niveau
     * @param niv ( representer le nivaeu a metre a jour  ) 
     */
    public void updateNiveau(Niveau niv ){
        try{
            
         
            
            pst = super.getCon().prepareStatement("UPDATE niveau SET specialiter_id_specialiter = ? ,libelle =? WHERE id_niveau = ?");
            pst.setInt(1,niv.getSpecialiter().getIdspecialiter());
            pst.setString(2,niv.getLibelle());
            pst.setInt(3,niv.getId_niveau());
          
            
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
          /**
     * cette methode permet d'avoir tous les niveau  presents dans la bd
     * @return une list  de type "ArrayList<Niveau>"
     */
    public List<Niveau> AllNiveau(){
        List<Niveau> listniveau = new ArrayList<Niveau>();
        
        try{
            Statement st = super.getCon().createStatement();
            rs = st.executeQuery("SELECT * FROM niveau,specialiter where specialiter_id_specialiter=id_specialiter");
            
            while(rs.next()){
                
                //recuper specialiter
                
                 int id = rs.getInt("id_specialter");
                String libelle  = rs.getString("libelle");
                Specialiter spc = new Specialiter(libelle,id);
                
                //recupere niveau
                
                Niveau niv = new  Niveau();
                niv.setId_niveau(rs.getInt("id_niveau"));
                niv.setLibelle(rs.getString("libelle"));
                niv.setSpecialiter(spc);
                listniveau.add(niv);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return listniveau;
    }
    
    
    
    
}