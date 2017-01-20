/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.Dao;

import com.miniprojet.model.Theme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author wilson black
 */
public class ThemesDao extends Dao{
    private boolean reponse;
    
    private ResultSet rs;
    private PreparedStatement pst;
    
    public ThemesDao(){
        super();
    }
    
    /**
     * cette methode permet d'ajouter un theme dans la bd
     * @param theme (elle prend un theme)
     */
    public void ajouterTheme(Theme theme){
    
        try{
           
            pst = super.getCon().prepareStatement("INSERT INTO themes VALUES(?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, theme.getLibelle());
            pst.setString(3,"libre");
            pst.executeUpdate(); 
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
   
    }

    /**
     * suppression d'un theme
     * @param id (id du theme a supprimer)
     */
    public void deleteTheme(int id){
        try{
            pst = super.getCon().prepareStatement("DELETE FROM themes WHERE id_theme = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * cette methode retourne l'id d'un theme
     * @param libelle (le libelle du theme dont on veut avoir son id)
     * @return id du theme
     */
    public int idTheme(String libelle){
        int id = 0;
        try{
         pst = super.getCon().prepareStatement("SELECT id_theme FROM themes WHERE libelle_theme = ?");
            pst.setString(1, libelle);
            rs = pst.executeQuery();
            
            if(rs.first())
            {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return id;
    }
    
    /**
     * mise a jour d'un theme
     * @param theme le nouveau theme 
     * @param id (l'id du theme sur lequel on veut faire une mofication ou une mise a jour)
     */
    public void updateTheme(Theme theme, int id){
        try{
            
            pst = super.getCon().prepareStatement("UPDATE themes SET libelle_theme = ?, etat_theme = ? WHERE id_theme = ?");
            pst.setString(1, theme.getLibelle());
            pst.setString(2, theme.getEtat_theme());
            pst.setInt(3, id);
            pst.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * cette methode permet d'avoir tous les themes presents dans la bd
     * @return un tableau de themes de type "ArrayList<Theme>"
     */
    public ArrayList<Theme> AllThemes(){
        ArrayList<Theme> themes = new ArrayList<Theme>();
        
        try{
            Statement st = super.getCon().createStatement();
            rs = st.executeQuery("SELECT * FROM themes");
            
            while(rs.next()){
                int id = rs.getInt("id_theme");
                String lib = rs.getString(2);
                String etat = rs.getString(3);
                Theme t = new Theme(lib,etat);
                t.setId(id);
                themes.add(t);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return themes;
    }
    
    
   
}
