/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.SpecialiterDao;
import com.miniprojet.model.Specialiter;
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
public class FXMLSpecialiterController implements Initializable {

    Specialiter spcglobal = new Specialiter();
    //text
    @FXML
    private TextField textspecialiter ;
    //buttton
    @FXML
    private Button btnenregistrespecialiter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
     
    //tabview
    @FXML
    private TableView<Specialiter> tabspeciali;
    @FXML
    private TableColumn<Specialiter,Integer> Cidspecialiter;
    @FXML
    private TableColumn<Specialiter, String> Cspeciliter;
    
    final ObservableList<Specialiter> data = FXCollections.observableArrayList();
    
    public  void savesspecialiter(ActionEvent event) throws IOException {
     
         if(!textspecialiter.getText().equals("")){
             
            SpecialiterDao  spdao = new SpecialiterDao();
            
            Specialiter spc = new Specialiter(textspecialiter.getText());
            
             spdao.ajouterSpecialiter(spc);
             List<Specialiter> listsp = new ArrayList<Specialiter>();
             listsp= spdao.AllSpecialiter();
             
              for(Specialiter sp :listsp){
            
             spc= sp;
         }
             data.add(spc);
             tabspeciali.setItems(data);
             textspecialiter.setText("");
             
         }
        // Alert al = new Alert(AlertType.WARNING);
        
        // Specialiter spc = new Specialiter("lccc");
        // spc.setIspecialiter(3);
        // spc.setIspecialiter(2);
       //  spdao.ajouterSpecialiter(spc);
        // spdao.deleteSpecialiter(1);
        // spdao.updateSpecialiter(spc);
    }
    
    
    
    public  void modifierspecialiter(ActionEvent event) throws IOException {
        
        if(!textspecialiter.getText().equals("")){
          Specialiter spc = new Specialiter();
          spc.setIspecialiter(spcglobal.getId_specialiter());
          spc.setLibelle(textspecialiter.getText());
        // spc.setIspecialiter(2);
       //  spdao.ajouterSpecialiter(spc);
        // spdao.deleteSpecialiter(1);
           SpecialiterDao  spdao = new SpecialiterDao();
           spdao.updateSpecialiter(spc);  
           
           
           
           List<Specialiter> listsp = new ArrayList<Specialiter>();
         listsp= spdao.AllSpecialiter();
         data.clear();
         for(Specialiter sp :listsp){
             //System.out.println(sp.getIdspecialiter());
              data.add(sp);
             
         }
         tabspeciali.setItems(data);
         textspecialiter.setText("");
         btnmodifier.setDisable(true);
         btnsupprimer.setDisable(true);
         btnenregistrespecialiter.setDisable(false);
            
        }
        
    }
    public  void supprimerspeciliter (ActionEvent event) throws IOException {
      
        SpecialiterDao  spdao = new SpecialiterDao(); 
        spdao.deleteSpecialiter(spcglobal.getId_specialiter());
        
        data.clear();
           List<Specialiter> listsp = new ArrayList<Specialiter>();
         listsp= spdao.AllSpecialiter();
         
         Cidspecialiter.setCellValueFactory(new PropertyValueFactory<Specialiter,Integer>("id_specialiter"));
         Cspeciliter.setCellValueFactory(new PropertyValueFactory<Specialiter,String>("Libelle"));
         
         for(Specialiter sp :listsp){
             //System.out.println(sp.getIdspecialiter());
              data.add(sp);
             
         }
         tabspeciali.setItems(data);
         btnmodifier.setDisable(true);
         btnsupprimer.setDisable(true);
         btnenregistrespecialiter.setDisable(false);
        
        
        
    }
    
    public  void affichespecialiter(Specialiter th){
        
        if(th!=null){
            
            btnmodifier.setDisable(false);
            btnsupprimer.setDisable(false);
            textspecialiter.setText(th.getLibelle());
            btnenregistrespecialiter.setDisable(true);
            
            spcglobal.setLibelle(th.getLibelle());
            spcglobal.setId_specialiter(th.getId_specialiter());
             
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnmodifier.setDisable(true);
        btnenregistrespecialiter.setDisable(false);
        btnsupprimer.setDisable(true);
        
        SpecialiterDao  spdao = new SpecialiterDao();
        
         List<Specialiter> listsp = new ArrayList<Specialiter>();
         listsp= spdao.AllSpecialiter();
         
         Cidspecialiter.setCellValueFactory(new PropertyValueFactory<Specialiter,Integer>("id_specialiter"));
         Cspeciliter.setCellValueFactory(new PropertyValueFactory<Specialiter,String>("Libelle"));
         
         for(Specialiter sp :listsp){
             //System.out.println(sp.getIdspecialiter());
              data.add(sp);
             
         }
         tabspeciali.setItems(data);
         textspecialiter.setText("");
         
         tabspeciali.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> affichespecialiter(newValue));
    }    
    
}
