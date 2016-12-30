/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.Enseignant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author durone
 */
public class EnseignantDAO extends Dao {
    
    private boolean reponse;
    
    private ResultSet rs;
    private PreparedStatement pst;
    
    public EnseignantDAO(){
        super();
    }
    /** 
     * cette function permet de recuperet le mot  de passe  de l enseignant
     * pour verifier son log sur l applica tion
     * @param enseignant
     * @return le mot de passe de l enseignant 
     */
    public String connect(Enseignant enseignant){
        
        String motpasse = null ;
        
         try{
            pst = super.getCon().prepareStatement("SELECT mot_passe FROM enseignant WHERE login = ?");
            pst.setString(1, enseignant.getLogin());
            rs = pst.executeQuery();
            
           while (rs.next()){
				motpasse=rs.getString("mot_passe");
			}
        }catch(Exception e){
            e.printStackTrace();
        }
        
     return   motpasse ;
    }
    
    
    
}
