/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.NiveauDao;
import com.miniprojet.Dao.SpecialiterDao;
import com.miniprojet.model.Niveau;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXMLNiveauController implements Initializable {

    Niveau nivglobal = new Niveau();
      //text
    @FXML
    private TextField textniveau;
    @FXML
    private TextField textinfoniveau;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnenregistreniveau;
    @FXML
    private Button btnmodifier;
    @FXML 
    private ComboBox Combospeciliter;
    
    //tabview
    @FXML
    private TableView<Niveau> tabniveau;
    @FXML
    private TableColumn<Niveau,Integer> Cidspeciliter;
    @FXML
    private TableColumn<Niveau,String> Cspeciliter;
    @FXML
    private TableColumn<Niveau,String> Cniveau;
    
    final ObservableList<Niveau> data = FXCollections.observableArrayList();
    ObservableList<String> combolis = FXCollections.observableArrayList();
    
    public  void saveniveau(ActionEvent event) throws IOException {
        
        if(!textniveau.getText().equals("")){
            
                NiveauDao nivdao = new NiveauDao();
                SpecialiterDao  spdao = new SpecialiterDao();
            
            
            
             List<Specialiter> listsp = new ArrayList<Specialiter>();
             listsp= spdao.AllSpecialiter();
             
              for(Specialiter sp :listsp){
            
                if(Combospeciliter.getValue().equals(sp.getLibelle())){
                    Niveau niveau = new Niveau(textniveau.getText(),sp);
                    nivdao.ajouterniveau(niveau);
                    
                     List<Niveau> lisniv = new ArrayList<Niveau>();
         lisniv=nivdao.AllNiveau();
         for(Niveau niv : lisniv){
             niveau= niv;
         }
         data.add(niveau);
         tabniveau.setItems(data);
                }
         }
             textniveau.setText("");
                
                
        //Niveau niveau = new Niveau("libelle",spc);
        //niveau.setId_niveau(1);
        //   nivdao.ajouterniveau(niveau);
            
            
            
        }
       
    }
    
   public  void modifierniveau (ActionEvent event) throws IOException {
       
       if(!textniveau.getText().equals("")){
            
                NiveauDao nivdao = new NiveauDao();
                SpecialiterDao  spdao = new SpecialiterDao();
            
            
            
             List<Specialiter> listsp = new ArrayList<Specialiter>();
             listsp= spdao.AllSpecialiter();
             
              for(Specialiter sp :listsp){
            
                if(Combospeciliter.getValue().equals(sp.getLibelle())){
                    Niveau niveau = new Niveau(textniveau.getText(),sp);
                    niveau.setId_niveau(nivglobal.getId_niveau());
                    nivdao.updateNiveau(niveau);
                    
        
        
                }
         }
              
         List<Niveau> lisniv = new ArrayList<Niveau>();
         lisniv=nivdao.AllNiveau();
         data.clear();
         for(Niveau niv : lisniv){
             
             data.add(niv);
             
         }
             tabniveau.setItems(data);
             textniveau.setText("");
             btnmodifier.setDisable(true);
             btnsupprimer.setDisable(true);
             btnenregistreniveau.setDisable(false);
                
                
        //Niveau niveau = new Niveau("libelle",spc);
        //niveau.setId_niveau(1);
        //   nivdao.ajouterniveau(niveau);
            
            
            
        }
           
          
           
       
        
    }
   public  void  supprimerniveau (ActionEvent event) throws IOException {
       
       
        NiveauDao nivdao = new NiveauDao();
           nivdao.deleteniveau(nivglobal.getId_niveau());
           data.clear();
           
            List<Niveau> lisniv = new ArrayList<Niveau>();
            lisniv=nivdao.AllNiveau();
         
        
          
        Cidspeciliter.setCellValueFactory(new PropertyValueFactory<Niveau, Integer>("id_niveau"));
        Cspeciliter.setCellValueFactory(new PropertyValueFactory<Niveau, String>("LibelSpecialiter"));
        Cniveau .setCellValueFactory(new PropertyValueFactory<Niveau,String>("libelle"));
         for(Niveau niv : lisniv){
             data.add(niv);
         }
        tabniveau.setItems(data);
        btnmodifier.setDisable(true);
        btnsupprimer.setDisable(true);
        btnenregistreniveau.setDisable(false);
       
        
    } 
   
   public  void afficheniv(Niveau niv){
        
        if(niv!=null){
            
            btnmodifier.setDisable(false);
            btnsupprimer.setDisable(false);
            textinfoniveau.setText(niv.getLibelSpecialiter());
            textniveau.setText(niv.getLibelle());
           
            btnenregistreniveau.setDisable(true);
            
            nivglobal.setId_niveau(niv.getId_niveau());
            
           
            
              
        }
        
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
      btnmodifier.setDisable(true);
      btnsupprimer.setDisable(true);
      textinfoniveau.setEditable(false);
      
        SpecialiterDao  nvdao = new SpecialiterDao();
        List<Specialiter> list = new ArrayList<Specialiter>();
        list=nvdao.AllSpecialiter();
         
            for( Specialiter spc:list){
          
         
          combolis.add(spc.getLibelle());
         
          
      }
          Combospeciliter.setItems(combolis);
          
             NiveauDao nivdao = new NiveauDao();
        //Niveau niveau = new Niveau("libelle",spc);
        //niveau.setId_niveau(1);
        //nivdao.ajouterniveau(niveau);
        //nivdao.deleteniveau(2);
         List<Niveau> lisniv = new ArrayList<Niveau>();
         lisniv=nivdao.AllNiveau();
         
        
          
        Cidspeciliter.setCellValueFactory(new PropertyValueFactory<Niveau, Integer>("id_niveau"));
        Cspeciliter.setCellValueFactory(new PropertyValueFactory<Niveau, String>("LibelSpecialiter"));
        Cniveau .setCellValueFactory(new PropertyValueFactory<Niveau,String>("libelle"));
         for(Niveau niv : lisniv){
             
             data.add(niv);
             
         }
        tabniveau.setItems(data);
      
       tabniveau.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficheniv(newValue));     
      
    }    
    
}
