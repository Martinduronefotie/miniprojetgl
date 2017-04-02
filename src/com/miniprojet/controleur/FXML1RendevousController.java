/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.EtudiantsDao;
import com.miniprojet.Dao.RendezVousDao;
import com.miniprojet.model.ModelEtudiants;
import com.miniprojet.model.RendezVous;
import com.miniprojet.model.Theme;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXML1RendevousController implements Initializable {
    
    RendezVous rdvglobal = new RendezVous();
    //combobox 
    
    @FXML 
    private  ComboBox comboetudiantmaticule;
    @FXML 
    private ComboBox conboheure;
    @FXML 
    private ComboBox combomin;
    @FXML 
    private ComboBox comboalert;
     //text  field       
    @FXML
    private TextArea  fieldrendevous;  
    @FXML
    private TextArea  fieldinforedevous;
    @FXML
    private TextArea  fieldraportrendevous;
    //button
    @FXML
    private Button btnenregistre;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsup ;
    @FXML
    private Button btnraport ;
    
    //datapiker
    @FXML 
    private DatePicker dateredevous;
    
    //tableview
    
    @FXML
    private TableView<RendezVous> tabrebdevous;
    
    @FXML 
    private TableColumn<RendezVous, String> Cdate;
    @FXML
    private TableColumn<RendezVous, Integer> Cid;
    @FXML
    private TableColumn<RendezVous, String> Cmatricule;
    @FXML
    private TableColumn<RendezVous, String> Cheure;
    @FXML
    private TableColumn<RendezVous, String> Cinterval;
    
     ObservableList<String> comboh = FXCollections.observableArrayList();
     ObservableList<String> comboAl = FXCollections.observableArrayList();
     ObservableList<String> combom = FXCollections.observableArrayList();
     ObservableList<String>  combolis = FXCollections.observableArrayList();
    final ObservableList<RendezVous> data = FXCollections.observableArrayList();
   
    public  void saverandezvous (ActionEvent event) throws IOException {
        
      if(!comboetudiantmaticule.getValue().equals("") 
         && !conboheure.getValue().equals("") && 
         !combomin.getValue().equals("") 
         && !dateredevous.getValue().equals("") 
         && !comboalert.getValue().equals("")
         && !fieldrendevous.getText().equals("") ){
          
      ModelEtudiants etudiant = new  ModelEtudiants();
      etudiant.setIdetudiants((String) comboetudiantmaticule.getValue());
      String heure = (String) conboheure.getValue()+":"+(String)combomin.getValue();
      String daterendevous= String.valueOf(dateredevous.getValue());
      String alert = String.valueOf(comboalert.getValue());
      String text= (String)fieldrendevous.getText();
      RendezVousDao rvddao= new RendezVousDao();
      RendezVous rdv = new RendezVous(text,"", heure,daterendevous, alert, etudiant);
      rvddao.ajouterRendezVous(rdv);
      fieldrendevous.setText("");
      
         data.clear();
         List<RendezVous> list = new ArrayList<RendezVous>();
         list = rvddao.AllRendezVous();
        for (RendezVous rdv1 : list) {

            data.add(rdv1);
            

        }
        tabrebdevous.setItems(data);
      
      }

      
    }
    
    
     public  void actualisation(ActionEvent event){
       
         EtudiantsDao etdao = new EtudiantsDao();
        List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=etdao.recupAllEtudiants();
          combolis.clear();
         for (ModelEtudiants etd:liustetd){
             
             combolis.add(etd.getIdetudiants());  
         }
         comboetudiantmaticule.setItems(combolis);
        
         
   }
    
    
    
    public  void modifierrendevous (ActionEvent event) throws IOException {
        
                if(!comboetudiantmaticule.getValue().equals("") 
         && !conboheure.getValue().equals("") && 
         !combomin.getValue().equals("") 
         && !dateredevous.getValue().equals("") 
         && !comboalert.getValue().equals("")
         && !fieldrendevous.getText().equals("") ){
          
      ModelEtudiants etudiant = new  ModelEtudiants();
      etudiant.setIdetudiants((String) comboetudiantmaticule.getValue());
      String heure = (String) conboheure.getValue()+":"+(String)combomin.getValue();
      String daterendevous= String.valueOf(dateredevous.getValue());
      String alert = String.valueOf(comboalert.getValue());
      String text= (String)fieldrendevous.getText();
      RendezVousDao rvddao= new RendezVousDao();
      RendezVous rdv = new RendezVous(text,"", heure,daterendevous, alert, etudiant);
      rdv.setId_rendezVous(rdvglobal.getId_rendezVous());
      rvddao.updateRendezVous(rdv);
      fieldrendevous.setText("");
      
         data.clear();
         List<RendezVous> list = new ArrayList<RendezVous>();
         list = rvddao.AllRendezVous();
        for (RendezVous rdv1 : list) {

            data.add(rdv1);
            

        }
        tabrebdevous.setItems(data);
        btnmodifier.setDisable(true);
        btnsup.setDisable(true);
        btnraport.setDisable(true);
        btnenregistre.setDisable(false);
      }
        
               
        
    }
    
    public  void supprimerrendevouz (ActionEvent event) throws IOException {
        
            RendezVousDao rvddao= new RendezVousDao();
            rvddao.deleteRendezVous(rdvglobal.getId_rendezVous());
               int selectedIndex = tabrebdevous.getSelectionModel().getSelectedIndex();
               tabrebdevous.getItems().remove(selectedIndex);
               btnmodifier.setDisable(true);
               btnsup.setDisable(true);
               btnraport.setDisable(true);
               btnenregistre.setDisable(false);
        
    }
    public  void rapportredevous (ActionEvent event) throws IOException {
        
        
         if(!comboetudiantmaticule.getValue().equals("") 
         && !conboheure.getValue().equals("") && 
         !combomin.getValue().equals("") 
         && !dateredevous.getValue().equals("") 
         && !comboalert.getValue().equals("")
         && !fieldrendevous.getText().equals("") && !fieldraportrendevous.getText().equals("") ){
          
      ModelEtudiants etudiant = new  ModelEtudiants();
      etudiant.setIdetudiants((String) comboetudiantmaticule.getValue());
      String heure = (String) conboheure.getValue()+":"+(String)combomin.getValue();
      String daterendevous= String.valueOf(dateredevous.getValue());
      String alert = String.valueOf(comboalert.getValue());
      String text= (String)fieldrendevous.getText();
      RendezVousDao rvddao= new RendezVousDao();
      RendezVous rdv = new RendezVous(text,fieldraportrendevous.getText(), heure,daterendevous, alert, etudiant);
      rdv.setId_rendezVous(rdvglobal.getId_rendezVous());
      rvddao.updateRendezVous(rdv);
      fieldrendevous.setText("");
      
         data.clear();
         List<RendezVous> list = new ArrayList<RendezVous>();
         list = rvddao.AllRendezVous();
        for (RendezVous rdv1 : list) {

            data.add(rdv1);
            

        }
        tabrebdevous.setItems(data);
        btnmodifier.setDisable(true);
        btnsup.setDisable(true);
        btnraport.setDisable(true);
        btnenregistre.setDisable(false);
      }
        
        
        
    }
    
    public void mat(){
         System.out.println("martin");
    }
    
    public  void  afficherdv(RendezVous rdv){
        
        System.out.println("martin");
        
        if(rdv!=null){
            
        btnmodifier.setDisable(false);
        btnsup.setDisable(false);
        btnraport.setDisable(false);
        btnenregistre.setDisable(true);
        
        rdvglobal.setId_rendezVous(rdv.getId_rendezVous());
        
        comboetudiantmaticule.setValue(rdv.getMatriIn());
        comboalert.setValue(rdv.getHreAlert());
        dateredevous.setValue(LocalDate.parse(rdv.getDate()));
        String  val = rdv.getTemps().substring(2);
        combomin.setValue(val);
        char val1 = rdv.getTemps().charAt(0);
        conboheure.setValue(val1);
        
         List<RendezVous> list = new ArrayList<RendezVous>();
         RendezVousDao rvddao= new RendezVousDao();
         list = rvddao.AllRendezVous();
         
         int id= rdv.getId_rendezVous();
        for (RendezVous rdv1 : list) {
             int id1= rdv1.getId_rendezVous();
            if(id1==id){
                
                fieldrendevous.setText(rdv1.getInformation());
                fieldinforedevous.setText(rdv1.getInformation());
                
               
                
            }
            

        }
        
        
        
         
        }
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnmodifier.setDisable(true);
        btnsup.setDisable(true);
        btnraport.setDisable(true);
        fieldinforedevous.setEditable(false);
        
        Cid.setCellValueFactory(new PropertyValueFactory<RendezVous, Integer>("id_rendezVous"));
        Cmatricule.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("matriIn"));
        Cheure.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("temps"));
        Cinterval.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("hreAlert"));
        Cdate.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("date"));
        
         RendezVousDao rvddao= new RendezVousDao();
         List<RendezVous> list = new ArrayList<RendezVous>();
         list = rvddao.AllRendezVous();
        for (RendezVous rdv : list) {

            data.add(rdv);
            

        }
        tabrebdevous.setItems(data);
        EtudiantsDao etdao = new EtudiantsDao();
        List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=etdao.recupAllEtudiants();
         
         for (ModelEtudiants etd :liustetd){
             
             combolis.add(etd.getIdetudiants());  
         }
         comboetudiantmaticule.setItems(combolis);
         
         
         for(int i=1 ;i<24;i++){
             
             comboh.add(String.valueOf(i));
         }
         for(int i=1 ;i<60;i++){
             
             combom.add(String.valueOf(i));
         }
         
         for(int i=1 ;i<24;i++){
             
             comboAl.add(String.valueOf(i));
         }
         comboalert.setItems(comboAl);
         conboheure.setItems(comboh);
         combomin.setItems(combom);
         
          tabrebdevous.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficherdv(newValue));
         
    }    
    
}
