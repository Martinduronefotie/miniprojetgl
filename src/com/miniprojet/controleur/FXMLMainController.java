/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXMLMainController implements Initializable {
    
    
    @FXML FXML1RendevousController fxml1Rendevous ;
   // @FXML AnchorPane fxml1Rendevous ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxml1Rendevous = new FXML1RendevousController();
        
        
        
                
    }    
    
}
