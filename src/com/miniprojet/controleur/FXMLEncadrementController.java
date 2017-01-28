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
public class FXMLEncadrementController implements Initializable {
    private Encadrement encglobal = new Encadrement() ;
    Theme th = new Theme();
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
    @FXML
    private TableView<Encadrement> tabencadrement;
    @FXML
    private TableColumn<Encadrement, Integer>Cidecad;
    @FXML
    private TableColumn<Encadrement, String> Cthemeenc;
    @FXML
    private TableColumn<Encadrement, String> Ctypeencadrem;
    @FXML
    private TableColumn<Encadrement, String> Cetaencadre;

    final ObservableList<Encadrement> data = FXCollections.observableArrayList();
     
  ObservableList<String> combolis = FXCollections.observableArrayList();
  ObservableList<String> combtype = FXCollections.observableArrayList();
   
   

  public void saveencaderment(ActionEvent event) throws IOException{
      
      
      
       comboencadrement.getValue();
      
       ThemesDao thdao = new ThemesDao();
       List<Theme> list = new ArrayList<Theme>();
       list=thdao.AllThemeslibre();
         
            for( Theme th :list){
          
              if(th.getLibelle().equals(comboencadrement.getValue())){
                  
         Enseignant es = new Enseignant("durone","durone");
         es.setId_enseignant(2);         
         EncadrementDao encDao = new EncadrementDao();
         Encadrement enc = new Encadrement(th,es, (String) combotypeencadrement.getValue(),"");
         th.setEtat_theme("prit");
         
         encDao.ajouterEncar(enc);
         thdao.updateTheme(th,th.getId());
         data.add(enc);
         tabencadrement.setItems(data);
         
              }
              
              
         
      }
      
      
      
  }
  
  
  public  void afficheencar(Encadrement enc){
        
        if(enc!=null){
            
            btnmodifier.setDisable(false);
            btnsupencadrement.setDisable(false);
            textinfo.setText(enc.getThdata());
            textinfocadrement.setText(enc.getType_encadrement());
            btnsaveenc.setDisable(true);
            
            encglobal.setId_encadremet(enc.getId_encadremet());
            System.out.println(encglobal.getId_encadremet());
            Enseignant es = new Enseignant("durone","durone");
            es.setId_enseignant(2);
            encglobal.setEnseignant(es);
            th.setLibelle(enc.getThdata());
            th.setId(enc.getIdthemes());
            encglobal.setTheme(th);
            encglobal.setType_encadrement(enc.getType_encadrement());
            encglobal.setEta_encadrement(enc.getEta_encadrement());
            
              
        }
        
        
    }
  public void modifierencadrement(ActionEvent event) throws IOException{
        comboencadrement.getValue();
       EncadrementDao encDao = new EncadrementDao();
       ThemesDao thdao = new ThemesDao();
       List<Theme> list = new ArrayList<Theme>();
       list=thdao.AllThemeslibre();
         
            for( Theme th :list){
          
              if(th.getLibelle().equals(comboencadrement.getValue())){
                  
         Enseignant es = new Enseignant("durone","durone");
         es.setId_enseignant(2);         
        
         Encadrement enc = new Encadrement(th,es, (String) combotypeencadrement.getValue(),"encours");
         enc.setId_encadremet(encglobal.getId_encadremet());
         
         
         
         encDao.updateEncadrement(enc);
        data.clear();
        
        
         
              }
              
              
              
         
      }
            
             List<Encadrement> listen= new ArrayList<Encadrement>();
         listen = encDao.Allencadrement();
            
            
        Cidecad.setCellValueFactory(new PropertyValueFactory<Encadrement, Integer>("id_encadremet"));
        Cthemeenc.setCellValueFactory(new PropertyValueFactory<Encadrement,String>("thdata"));
        Ctypeencadrem.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("Type_encadrement"));
        Cetaencadre.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("eta_encadrement"));
        
     
        for (Encadrement enc : listen) {

            data.add(enc);
            

        }
        tabencadrement.setItems(data);
             
   }
   public void suppencadrement(ActionEvent event) throws IOException{
        btnsupencadrement.setDisable(true);
         btnmodifier.setDisable(true);
         btnsaveenc.setDisable(false);
         btnsupencadrement.setDisable(true);
         btnmodifier.setDisable(true);
         btnsaveenc.setDisable(false);
         EncadrementDao encDao = new EncadrementDao();
        
       
         
          encDao.deleteEncadrement(encglobal.getId_encadremet());
          th.setEtat_theme("libre");
            ThemesDao thdao = new ThemesDao();
            thdao.updateTheme(th,th.getId());
          
          data.clear();
          combolis.clear();
          
          
        List<Theme> list = new ArrayList<Theme>();
         list=thdao.AllThemeslibre();
         
            for( Theme etd :list){
          
         
          combolis.add(etd.getLibelle());
         
          
      }
            
            comboencadrement.setItems(combolis);
          
          
       
        
         List<Encadrement> listen= new ArrayList<Encadrement>();
         listen = encDao.Allencadrement();
            
            
        Cidecad.setCellValueFactory(new PropertyValueFactory<Encadrement, Integer>("id_encadremet"));
        Cthemeenc.setCellValueFactory(new PropertyValueFactory<Encadrement,String>("thdata"));
        Ctypeencadrem.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("Type_encadrement"));
        Cetaencadre.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("eta_encadrement"));
        
     
        for (Encadrement enc : listen) {

            data.add(enc);
            

        }
        tabencadrement.setItems(data);
        
        textinfo.setText("");
        textinfocadrement.setText("");
          
          
         
        
         
    
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
            
         EncadrementDao encDao = new EncadrementDao();
       
        
         List<Encadrement> listen= new ArrayList<Encadrement>();
         listen = encDao.Allencadrement();
            
            
        Cidecad.setCellValueFactory(new PropertyValueFactory<Encadrement, Integer>("id_encadremet"));
        Cthemeenc.setCellValueFactory(new PropertyValueFactory<Encadrement,String>("thdata"));
        Ctypeencadrem.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("Type_encadrement"));
        Cetaencadre.setCellValueFactory(new PropertyValueFactory<Encadrement, String>("eta_encadrement"));
        
     
        for (Encadrement enc : listen) {

            data.add(enc);
            

        }
        tabencadrement.setItems(data);
            
            
         
        tabencadrement.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficheencar(newValue));    
      
      
      
    }    
    
}
