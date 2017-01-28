/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

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
public class SpecialiterDao extends Dao{
    
    private boolean reponse;
    
    private ResultSet rs;
    private PreparedStatement pst;
    
    public SpecialiterDao(){
        
       super();
       
    }
   
    /**
     * cette methode permet d'ajouter une specialiter dans la bd
     * @param spc (representer la specialiter)
     */
    public void ajouterSpecialiter(Specialiter spc){
    
        try{
           
           
            pst = super.getCon().prepareStatement("INSERT INTO specialiter VALUES(?,?)");
            pst.setInt(1, 0);
            pst.setString(2, spc.getLibelle());
           
            pst.executeUpdate(); 
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
   
    } 
    
     /**
     * suppression d'une specialiter
     * @param id (id de  a specialiter)
     */
    public void deleteSpecialiter(int id){
        try{
            pst = super.getCon().prepareStatement("DELETE FROM specialiter WHERE id_specialiter = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     /**
     * mise a jour d'une specialiter
     * @param spc ( representer la specialiter a metre a jour ) 
     */
    public void updateSpecialiter(Specialiter spc ){
        try{
            
            pst = super.getCon().prepareStatement("UPDATE specialiter SET libelle = ? WHERE id_specialiter = ?");
            pst.setString(1, spc.getLibelle());
          
            pst.setInt(2,spc.getIdspecialiter());
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
       /**
     * cette methode permet d'avoir tous les specialiter  presents dans la bd
     * @return une list  de type "ArrayList<Specialiter>"
     */
    public List<Specialiter> AllSpecialiter(){
        List<Specialiter> specialiter = new ArrayList<Specialiter>();
        
        try{
            Statement st = super.getCon().createStatement();
            rs = st.executeQuery("SELECT * FROM specialiter");
            
            while(rs.next()){
                int id = rs.getInt("id_specialiter");
                
                String libelle  = rs.getString("libelle");
                Specialiter spc = new Specialiter(libelle,id);
                specialiter.add(spc);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return specialiter;
    }
    
    
     public Specialiter oneSpecialiter(int id){
        
        Specialiter specialiter = new Specialiter() ;
        
         try{
           pst = super.getCon().prepareStatement("SELECT * FROM specialiter WHERE id_specialiter =?");
            pst.setInt(1,id);
            rs = pst.executeQuery();
            
           while (rs.next()){
				specialiter.setLibelle(rs.getString("Libelle"));
                                specialiter.setIspecialiter(id);
                                
			}
        }catch(Exception e){
            e.printStackTrace();
        }
        
     return  specialiter ;
    }
    
    
    
    
}
