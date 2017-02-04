/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.AnneAcademiqueDao;
import com.miniprojet.model.ModelAnneAcademique;
import com.miniprojet.model.Specialiter;
import com.miniprojet.model.Theme;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXMLAnneeAcademiqueController implements Initializable {
ModelAnneAcademique mdglobal = new ModelAnneAcademique();
    //text
     @FXML
     private TextField textannesacademiques ;
     //bouton
     @FXML
     private Button btnenregistre ;
     @FXML
     private Button btnmodifier;
     @FXML
     private Button   btnsupp ;
     //tabview 
     @FXML
     private TableView<ModelAnneAcademique> tabanneacademiques;
     @FXML
     private TableColumn<ModelAnneAcademique,Integer> Cid;
     @FXML
     private TableColumn<ModelAnneAcademique,String> Clibelle;
     
     final ObservableList<ModelAnneAcademique> data = FXCollections.observableArrayList();
     
     public  void saveanneAcademique (ActionEvent event) throws IOException {
         
         if(!textannesacademiques.getText().equals("")){
             
               ModelAnneAcademique ann = new ModelAnneAcademique(textannesacademiques.getText());
               AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
               daoanneac.ajouteAnneAcd(ann);
               textannesacademiques.setText("");
              
               List<ModelAnneAcademique>  list = new ArrayList<ModelAnneAcademique>();
         
               list=  daoanneac.AllAnneAc();
               data.clear();
          
        
             for(ModelAnneAcademique md :list) {

                 data.add(md);

            }
         tabanneacademiques.setItems(data);
         }
         
     }
     
     public  void modifieranneAc(ActionEvent event) throws IOException {
         
         if(!textannesacademiques.getText().equals("")){
             
               ModelAnneAcademique ann = new ModelAnneAcademique(textannesacademiques.getText());
               ann.setId_anne_accademiques(mdglobal.getId_anne_accademiques());
               AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
               daoanneac.updateniveau(ann);
               textannesacademiques.setText("");
              
               List<ModelAnneAcademique>  list = new ArrayList<ModelAnneAcademique>();
         
               list=  daoanneac.AllAnneAc();
               data.clear();
          
        
             for(ModelAnneAcademique md :list) {

                 data.add(md);

            }
          tabanneacademiques.setItems(data);
          btnmodifier.setDisable(true);
                btnsupp.setDisable(true);
                btnenregistre.setDisable(false);
                textannesacademiques.setText("");
         }
         
     }
             
    public void supprimerAnneeAcad(ActionEvent event) throws IOException {
        
         AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
         daoanneac.deleteAnneAcd(mdglobal.getId_anne_accademiques());
         
          int selectedIndex = tabanneacademiques.getSelectionModel().getSelectedIndex();
                tabanneacademiques.getItems().remove(selectedIndex);
                btnmodifier.setDisable(true);
                btnsupp.setDisable(true);
                btnenregistre.setDisable(false);
                textannesacademiques.setText("");
        
         
     }
    
    public  void  afficheAnnAc(ModelAnneAcademique md){
        if(md!=null){
            
        btnenregistre.setDisable(true);
        btnmodifier.setDisable(false);
        btnsupp.setDisable(false);
        mdglobal.setId_anne_accademiques(md.getId_anne_accademiques());
        textannesacademiques.setText(md.getLibelle());
        
        }
       
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnmodifier.setDisable(true);
        btnsupp.setDisable(true);
        
         AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
         List<ModelAnneAcademique>  list = new ArrayList<ModelAnneAcademique>();
         
         list=  daoanneac.AllAnneAc();
        
         Cid.setCellValueFactory(new PropertyValueFactory<ModelAnneAcademique, Integer>("id_anne_accademiques"));
         Clibelle.setCellValueFactory(new PropertyValueFactory<ModelAnneAcademique, String>("libelle"));
        
        for(ModelAnneAcademique md :list) {

            data.add(md);

        }
         tabanneacademiques.setItems(data);
          tabanneacademiques.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficheAnnAc(newValue));
    }    
    
}
