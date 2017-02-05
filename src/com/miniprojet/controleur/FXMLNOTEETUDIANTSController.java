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
public class FXMLNOTEETUDIANTSController implements Initializable {
    ModelEtudiants etdglobal = new ModelEtudiants();
    //text
    @FXML
    private TextField textnote;
    //boutton
    @FXML
    private Button btnenregistre;
    
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
    @FXML
    private TableColumn<ModelEtudiants, Double> Cnote;
    @FXML
    private TableColumn<ModelEtudiants, Integer> Cnumencadrement ;
    
    final ObservableList<ModelEtudiants> data = FXCollections.observableArrayList();
   
    public  void  enregistrenote(ActionEvent event) throws IOException {
        
        
            Encadrement encadrement = new Encadrement();
            EncadrementDao encadrementDao = new EncadrementDao();
            EtudiantsDao etudiantsDao = new  EtudiantsDao();
            System.out.println(etdglobal.getIdetudiants());
            encadrement= encadrementDao.recupUnEncadrement(etdglobal.getNumencadrement());
            ModelEtudiants modelEtudiants = new ModelEtudiants(etdglobal.getIdetudiants(),encadrement,etdglobal.getNom(),etdglobal.getPrenom(),Double.valueOf(textnote.getText()));
            etudiantsDao.updateEtd(modelEtudiants);
            
           encadrement.setEta_encadrement("finish");
           encadrementDao.updateEncadrement(encadrement);
           Theme thm = new Theme();
           thm=encadrement.getTheme();
           ThemesDao thdao = new ThemesDao();
           thm.setEtat_theme("libre");
           thdao.updateTheme(thm,thm.getId());
           
            
          EtudiantsDao etdao = new EtudiantsDao();
          List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=  etdao.recupAllEtudiantsnote();
         data.clear();
          for (ModelEtudiants etd : liustetd) {
            Encadrement ec = new Encadrement();
            Theme th = new Theme();
            ec= etd.getEncadrement();
           // System.out.println(etd.getEncadrement().getTheme().getLibelle());
           // System.out.println(etd.getEncadrement().getEta_encadrement());
            th= etd.getEncadrement().getTheme();
            data.add(etd);
           
        }
            
        
        
    }
    
   
    
    public  void afficheetudians(ModelEtudiants etd){
         
         
       if(etd!=null){
           
        etdglobal=etd;  
        
      
        //btnenregistre.setDisable(true);
        //etudiantsglobal.setIdetudiants(e);
        textnote.setText(String.valueOf(etd.getNote()));
        
           
       } 
        
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
       
        
         EtudiantsDao etdao = new EtudiantsDao();
          List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=  etdao.recupAllEtudiantsnote();
         
        Cmatricule.setCellValueFactory(new PropertyValueFactory<ModelEtudiants,String>("idetudiants"));
        Cnom.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("nom"));
        Cprenom.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("prenom"));
        Cthemes.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("libelle"));
        Ctypeencadrement.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("Type_encadrement"));
        Cetatencadrement.setCellValueFactory(new PropertyValueFactory<ModelEtudiants, String>("eta_encadrement"));
        Cnote.setCellValueFactory(new PropertyValueFactory<ModelEtudiants,Double>("note"));
        Cnumencadrement.setCellValueFactory(new PropertyValueFactory<ModelEtudiants,Integer>("numencadrement"));
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
       tabetudiants.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> afficheetudians(newValue));
    }    
    
}
