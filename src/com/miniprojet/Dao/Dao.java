/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author wilson black
 */
public abstract class Dao {
    private Connection con;
  
    /**
     * constructeur DAO dans lequel je charge la connection a la bd 
     */
       public Dao(){
    
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/miniprojetgl";
          String user = "root";  
           String passwd = "";
 
      con = DriverManager.getConnection(url, user, passwd);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
     
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
   
    
}
