/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.EncadrementDao;
import com.miniprojet.Dao.ThemesDao;
import com.miniprojet.model.Encadrement;
import com.miniprojet.model.Enseignant;
import com.miniprojet.model.Theme;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXMLEncadrementController implements Initializable {

    //text
    @FXML
    private TextField textinfo;
    @FXML
    private TextField textinfocadrement;
    //combo
    @FXML
    private ComboBox comboencadrement;
    @FXML
    private ComboBox  combotypeencadrement ;
    //buttton
    @FXML
    private Button btnsaveenc;
    @FXML
    private Button btnmodifier;
     @FXML
    private Button btnsupencadrement;
    //tabview
     
  ObservableList<String> combolis = FXCollections.observableArrayList();
  ObservableList<String> combtype = FXCollections.observableArrayList();
   
   

  public void saveencaderment(ActionEvent event) throws IOException{
      
      
      
      comboencadrement.getValue();
      
       ThemesDao thdao = new ThemesDao();
       List<Theme> list = new ArrayList<Theme>();
       list=thdao.AllThemeslibre();
         
            for( Theme th :list){
          
              if(th.getLibelle().equals( comboencadrement.getValue())){
                  
         Enseignant es = new Enseignant("durone","durone");
         es.setId_enseignant(2);         
         EncadrementDao encDao = new EncadrementDao();
         Encadrement enc = new Encadrement(th,es, (String) combotypeencadrement.getValue(),"");
         th.setEtat_theme("prit");
         
         encDao.ajouterEncar(enc);
         thdao.updateTheme(th,th.getId());
              }
              
         
      }
      
      
      
  }
  public void modifierencadrement(ActionEvent event) throws IOException{
             
   }
   public void suppencadrement(ActionEvent event) throws IOException{
         
    
   }
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      textinfo.setEditable(false);
      btnmodifier.setDisable(true);
      btnsupencadrement.setDisable(true);
      textinfocadrement.setEditable(false);
      
        ThemesDao thdao = new ThemesDao();
        List<Theme> list = new ArrayList<Theme>();
         list=thdao.AllThemeslibre();
         
            for( Theme etd :list){
          
         
          combolis.add(etd.getLibelle());
         
          
      }
            
            comboencadrement.setItems(combolis);
            combtype.add("stage");
            combtype.add("projet tutoré");
            combtype.add("projet accadémique");
            
            combotypeencadrement.setItems(combtype);
            
            
            
      
      
      
    }    
    
}
