/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.controleur;

import com.miniprojet.Dao.EncadrementDao;
import com.miniprojet.Dao.EtudiantsDao;
import com.miniprojet.Dao.ThemesDao;
import com.miniprojet.model.Encadrement;
import com.miniprojet.model.ModelEtudiants;
import com.miniprojet.model.Theme;
import java.awt.Desktop.Action;
import java.awt.Dialog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class FXMLEtudiantsController implements Initializable {
    
    ModelEtudiants etudiantsglobal  = new  ModelEtudiants();
    //text
    @FXML
    private TextField textinfoencadrement;
    @FXML
    private TextField textnom;
    @FXML
    private TextField textprenom;
    @FXML
    private TextField textinfotheme;

    //buttton
    @FXML
    private Button btnenregistreetudiant;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;

    //combobox
    @FXML
    ComboBox comboetudiant;

    //tabview
    @FXML
    private TableView<ModelEtudiants> tabetudiants;
    @FXML
    private TableColumn<ModelEtudiants, String> Cmatricule;
    @FXML
    private TableColumn<ModelEtudiants, String> Cnom;
    @FXML
    private TableColumn<ModelEtudiants, String> Cprenom;
    @FXML
    private TableColumn<ModelEtudiants, String> Cthemes;
    @FXML
    private TableColumn<ModelEtudiants, String> Ctypeencadrement;
    @FXML
    private TableColumn<ModelEtudiants, String> Cetatencadrement;
    
    final ObservableList<ModelEtudiants> data = FXCollections.observableArrayList();
    
    ObservableList<String> combolis = FXCollections.observableArrayList();
   
    
    public void savaetudians(ActionEvent event) throws IOException {
        
        if(!textnom.getText().equals("") && !textprenom.getText().equals("")){
            
            String val =(String) comboetudiant.getValue();
            Encadrement encadrement = new Encadrement();
            EncadrementDao encadrementDao = new EncadrementDao();
            EtudiantsDao etudiantsDao = new  EtudiantsDao();
            
            encadrement= encadrementDao.recupUnEncadrement(Integer.parseInt(val));
            ModelEtudiants modelEtudiants = new ModelEtudiants("",encadrement,textnom.getText(),textprenom.getText(),0d);
            etudiantsDao.ajouterETudiants(modelEtudiants);
            
            encadrement.setEta_encadrement("encours");
            encadrementDao.updateEncadrement(encadrement);
            
            
            ThemesDao thdao = new ThemesDao();
            List<Theme> list = new ArrayList<Theme>();
            list = thdao.AllThemes();
            EtudiantsDao etdao = new EtudiantsDao();
             List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
            liustetd=  etdao.recupAllEtudiants();
            data.clear();
           
            for (ModelEtudiants etd : liustetd) {
            Encadrement ec = new Encadrement();
            Theme th = new Theme();
            ec= etd.getEncadrement();
          
            th= etd.getEncadrement().getTheme();
            data.add(etd);
            
        }
        
       
       
        tabetudiants.setItems(data);
        
        
        EncadrementDao encdao = new  EncadrementDao();
        List<Encadrement> listen= new ArrayList<Encadrement>();
        listen = encdao.Allencadrement();
        //combolis.clear();
        for (Encadrement enc : listen) {

             combolis.add(String.valueOf(enc.getId_encadremet()));
        }
        comboetudiant.setItems(combolis);
        }
       
               
        
    }
    
     public  void afficheetudians(ModelEtudiants etd){
         
         
       if(etd!=null){
           
        btnmodifier.setDisable(false);
        btnsupprimer.setDisable(false);
        btnenregistreetudiant.setDisable(true);
       //etudiantsglobal.setIdetudiants(e);
        textnom.setText(etd.getNom());
        textprenom.setText(etd.getPrenom());
         textinfoencadrement.setText(etd.getIdetudiants());
           
       } 
        
        
    }

    public void modifieretudiants(ActionEvent event) throws IOException {
        
        if(!textnom.getText().equals("") && !textprenom.getText().equals("")){
            
            String val =(String) comboetudiant.getValue();
            Encadrement encadrement = new Encadrement();
            EncadrementDao encadrementDao = new EncadrementDao();
            EtudiantsDao etudiantsDao = new  EtudiantsDao();
            
            encadrement= encadrementDao.recupUnEncadrement(Integer.parseInt(val));
            ModelEtudiants modelEtudiants = new ModelEtudiants("",encadrement,textnom.getText(),textprenom.getText(),0.0);
            modelEtudiants.setIdetudiants(textinfoencadrement.getText());
            etudiantsDao.updateEtd(modelEtudiants);
            
            encadrement.setEta_encadrement("encours");
            encadrementDao.updateEncadrement(encadrement);
            
            
            ThemesDao thdao = new ThemesDao();
            List<Theme> list = new ArrayList<Theme>();
            list = thdao.AllThemes();
            EtudiantsDao etdao = new EtudiantsDao();
            List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
            liustetd=  etdao.recupAllEtudiants();
            //combolis.remove( (Object)comboetudiant.getValue());
            data.clear();
            
           
            for (ModelEtudiants etd : liustetd) {
            Encadrement ec = new Encadrement();
            Theme th = new Theme();
            ec= etd.getEncadrement();
          
            th= etd.getEncadrement().getTheme();
            data.add(etd);
            
        }
        
       
       
        tabetudiants.setItems(data);
        
        }
       btnmodifier.setDisable(true);
       btnsupprimer.setDisable(true);
       btnenregistreetudiant.setDisable(false);
    }

    public void supprimeretudiants(ActionEvent event) throws IOException {
         Encadrement ec1 = new Encadrement();
         EtudiantsDao etdao = new EtudiantsDao();
         ModelEtudiants enEtudiants= new  ModelEtudiants();
         enEtudiants=etdao.recupUnEtudiants(textinfoencadrement.getText());
         ec1= enEtudiants.getEncadrement();
         ec1.setEta_encadrement("cree");
         EncadrementDao endao= new EncadrementDao();
         endao.updateEncadrement(ec1);
         etdao.deleteEtd(textinfoencadrement.getText());
         btnmodifier.setDisable(true);
         btnsupprimer.setDisable(true);
         btnenregistreetudiant.setDisable(false);
         textnom.setText("");
         textprenom.setText("");
         textinfoencadrement.setText("");
         textinfotheme.setText(" ");
         
       
        tabetudiants.setItems(data);
        
        tabetudiants.setFocusTraversable(true);
        
        int selectedIndex = tabetudiants.getSelectionModel().getSelectedIndex();
        tabetudiants.getItems().remove(selectedIndex);
        
        btnmodifier.setDisable(true);
        btnsupprimer.setDisable(true);
        btnenregistreetudiant.setDisable(false);
    
    }
    
   
    
    public void textinfo(String info){
        textinfotheme.setText(info);
       
    }

    public void methhodchoithemes(ActionEvent event) throws IOException {
      
       String val= (String) comboetudiant.getValue();
       EncadrementDao encdao = new  EncadrementDao();
       Encadrement enc = new Encadrement();
       enc=encdao.recupUnEncadrement(Integer.parseInt(val));
       textinfotheme.setText(enc.getTheme().getLibelle());
       //textinfotheme.setText(val);
       
   
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnmodifier.setDisable(true);
        btnsupprimer.setDisable(true);
        textinfotheme.setEditable(false);
        textinfoencadrement.setEditable(false);
        // TODO
          ThemesDao thdao = new ThemesDao();
          List<Theme> list = new ArrayList<Theme>();
          list = thdao.AllThemes();
          EtudiantsDao etdao = new EtudiantsDao();
          List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=  etdao.recupAllEtudiants();
         
        Cmatricule.setCellValueFactory(new PropertyValueFactory<ModelEtudiants,String>("idetudiants"));
        Cnom.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("nom"));
        Cprenom.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("prenom"));
        Cthemes.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("libelle"));
        Ctypeencadrement.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("Type_encadrement"));
        Cetatencadrement.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("eta_encadrement"));
        for (ModelEtudiants etd : liustetd) {
            Encadrement ec = new Encadrement();
            Theme th = new Theme();
            ec= etd.getEncadrement();
           // System.out.println(etd.getEncadrement().getTheme().getLibelle());
           // System.out.println(etd.getEncadrement().getEta_encadrement());
            th= etd.getEncadrement().getTheme();
            data.add(etd);
           
        }
        
       
       
        tabetudiants.setItems(data);
       
        EncadrementDao encdao = new  EncadrementDao();
        List<Encadrement> listen= new ArrayList<Encadrement>();
        listen = encdao.Allencadrement();
        combolis.clear();
        for (Encadrement enc : listen) {

            combolis.add(String.valueOf( enc.getId_encadremet()));
            

        }
        comboetudiant.setItems(combolis);
         // int selectedIndex = tabetudiants.getSelectionModel().getSelectedIndex();
       // tabetudiants.getItems().remove(selectedIndex);
        tabetudiants.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficheetudians(newValue));
        
    }

}
