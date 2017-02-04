/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.controleur;

import com.miniprojet.Dao.AnneAcademiqueDao;
import com.miniprojet.Dao.Etudians_AnneAcademique_NiveauDao;
import com.miniprojet.Dao.EtudiantsDao;
import com.miniprojet.Dao.NiveauDao;
import com.miniprojet.model.MEtudians_AnneAcademique_Niveau;
import com.miniprojet.model.ModelAnneAcademique;
import com.miniprojet.model.ModelEtudiants;
import com.miniprojet.model.Niveau;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author durone
 */
public class FXMLAnneacademiquesetudiantsController implements Initializable {
   MEtudians_AnneAcademique_Niveau mdeglobal= new MEtudians_AnneAcademique_Niveau();
   
    //combobox
    @FXML
    ComboBox comboetudiants;
    @FXML
    ComboBox comboannes;
    @FXML
    ComboBox comboniveau;
    @FXML
    ComboBox combolistespecialiter;
    
  //buttton
    @FXML
    private Button btnenregistre;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupp;
    
    //tabview
    @FXML
    private TableView<MEtudians_AnneAcademique_Niveau>tabannAcEtu;
    @FXML
    private TableColumn<MEtudians_AnneAcademique_Niveau,Integer> Cid;
    @FXML
    private TableColumn<MEtudians_AnneAcademique_Niveau,String> Cmatricule;
    @FXML
    private TableColumn<MEtudians_AnneAcademique_Niveau,String> CannAcEtu;
    @FXML
    private TableColumn<MEtudians_AnneAcademique_Niveau,String> Cniveau;
    
    ObservableList<String> datamatri = FXCollections.observableArrayList();
     
    ObservableList<String> datacombolistespecialiter = FXCollections.observableArrayList();
     
    ObservableList<String> datacomboannes = FXCollections.observableArrayList();
     
    ObservableList<String> datacomboniveau = FXCollections.observableArrayList();
    ObservableList<MEtudians_AnneAcademique_Niveau> datatable = FXCollections.observableArrayList();
    
    public  void saveanneetudiant(ActionEvent event) throws IOException{
        
        if(!comboetudiants.getValue().equals("")&& 
           !comboannes.getValue().equals("") && 
           !comboniveau.getValue().equals("") && 
           !combolistespecialiter.getValue().equals("")){
             Niveau niv1 = new Niveau();
             ModelAnneAcademique md1 = new  ModelAnneAcademique();
            
             List<ModelAnneAcademique>  list = new ArrayList<ModelAnneAcademique>();
             AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
             list=  daoanneac.AllAnneAc();
             for(ModelAnneAcademique md :list) {
                    
                 if( md.getLibelle().equals(comboannes.getValue())){
                     md1=md;
                     System.out.println(md1.getLibelle());
                     
                 }
             }
            NiveauDao nivdao = new NiveauDao();
            List<Niveau> lisniv = new ArrayList<Niveau>();
            lisniv=nivdao.AllNiveau();
            for(Niveau niv : lisniv){
            
                if(niv.getSpecialiter().getLibelle().equals(combolistespecialiter.getValue())){
                    niv1=niv;
                }
         }
            
        ModelEtudiants etudiants= new ModelEtudiants();
        etudiants.setIdetudiants((String) comboetudiants.getValue());
        MEtudians_AnneAcademique_Niveau mean = new MEtudians_AnneAcademique_Niveau(etudiants, md1, niv1);
        Etudians_AnneAcademique_NiveauDao dao = new Etudians_AnneAcademique_NiveauDao();
        dao.saveEtAnnN(mean);
        
           
         
         List<MEtudians_AnneAcademique_Niveau> listetan = new ArrayList<MEtudians_AnneAcademique_Niveau>();
         listetan = dao.recupUnEtudiantsAnnAcd();
         datatable.clear();
    
         for(MEtudians_AnneAcademique_Niveau mde : listetan){
             
             datatable.add(mde);
            
         }
         
         tabannAcEtu.setItems(datatable);
        
        
            
        }
        
         
        
        
    }
    public  void modifierannes(ActionEvent event) throws IOException{
        
        if(!comboetudiants.getValue().equals("")&& 
           !comboannes.getValue().equals("") && 
           !comboniveau.getValue().equals("") && 
           !combolistespecialiter.getValue().equals("")){
             Niveau niv1 = new Niveau();
             ModelAnneAcademique md1 = new  ModelAnneAcademique();
            
             List<ModelAnneAcademique>  list = new ArrayList<ModelAnneAcademique>();
             AnneAcademiqueDao daoanneac = new AnneAcademiqueDao();
             list=  daoanneac.AllAnneAc();
             for(ModelAnneAcademique md :list) {
                    
                 if( md.getLibelle().equals(comboannes.getValue())){
                     md1=md;
                     System.out.println(md1.getLibelle());
                     
                 }
             }
            NiveauDao nivdao = new NiveauDao();
            List<Niveau> lisniv = new ArrayList<Niveau>();
            lisniv=nivdao.AllNiveau();
            for(Niveau niv : lisniv){
            
                if(niv.getSpecialiter().getLibelle().equals(combolistespecialiter.getValue())){
                    niv1=niv;
                }
         }
            
        ModelEtudiants etudiants= new ModelEtudiants();
        etudiants.setIdetudiants((String) comboetudiants.getValue());
        MEtudians_AnneAcademique_Niveau mean = new MEtudians_AnneAcademique_Niveau(etudiants, md1, niv1);
        mean.setId(mdeglobal.getId());
        Etudians_AnneAcademique_NiveauDao dao = new Etudians_AnneAcademique_NiveauDao();
        dao.misajourEAN(mean);
        
           
         
         List<MEtudians_AnneAcademique_Niveau> listetan = new ArrayList<MEtudians_AnneAcademique_Niveau>();
         listetan = dao.recupUnEtudiantsAnnAcd();
         datatable.clear();
    
         for(MEtudians_AnneAcademique_Niveau mde : listetan){
             
             datatable.add(mde);
            
         }
         
         tabannAcEtu.setItems(datatable);
        
        
            
        }
        
    }
    public  void supprimerAnnEtu(ActionEvent event) throws IOException{
        
        
         Etudians_AnneAcademique_NiveauDao dao = new Etudians_AnneAcademique_NiveauDao();
         dao.deleteEtAnnN(mdeglobal.getId());
         int selectedIndex = tabannAcEtu.getSelectionModel().getSelectedIndex();
         tabannAcEtu.getItems().remove(selectedIndex);
         btnmodifier.setDisable(true);
         btnsupp.setDisable(true);
         btnenregistre.setDisable(false);
         
         
    }
    
    
    
    public  void choixniveau(ActionEvent event) throws IOException{
      
         NiveauDao nivdao = new NiveauDao();
         datacombolistespecialiter.clear();
         
         List<Niveau> list = new ArrayList<Niveau>();
         list=nivdao.recuperelibelleniveau((String) comboniveau.getValue());
         
         for(Niveau niv:list){
             
            datacombolistespecialiter.add(niv.getSpecialiter().getLibelle());
             
             
         }
         
         combolistespecialiter.setItems(datacombolistespecialiter);
         
                
    }
    
    public void affichAnnEtu(MEtudians_AnneAcademique_Niveau mdae){
        
        if(mdae!=null){
              btnmodifier.setDisable(false);
              btnsupp.setDisable(false);
              btnenregistre.setDisable(true);
              mdeglobal.setId(mdae.getId());
              comboetudiants.setValue(mdae.getMatri());
              comboannes.setValue(mdae.getAnneac());
              comboniveau.setValue(mdae.getNiveau());
            
            
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnmodifier.setDisable(true);
        btnsupp.setDisable(true);
        EtudiantsDao etdao = new EtudiantsDao();
        List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=etdao.recupAllEtudiants();
         
         for (ModelEtudiants etd :liustetd){
             
             datamatri.add(etd.getIdetudiants());  
         }
         comboetudiants.setItems(datamatri);
         
         datacomboannes.add("2016-2017");
         datacomboannes.add("2017-2018");
         
         comboannes.setItems(datacomboannes);
          NiveauDao nivdao = new NiveauDao();
         
          List<Niveau> lisniv = new ArrayList<Niveau>();
            lisniv=nivdao.AllNiveau();
            
             for(Niveau niv : lisniv){
             datacomboniveau.add(niv.getLibelle());
         }
          
            
         Etudians_AnneAcademique_NiveauDao dao = new Etudians_AnneAcademique_NiveauDao();
         List<MEtudians_AnneAcademique_Niveau> listetan = new ArrayList<MEtudians_AnneAcademique_Niveau>();
         listetan = dao.recupUnEtudiantsAnnAcd();
         comboniveau.setItems(datacomboniveau);
         Cid.setCellValueFactory(new PropertyValueFactory<MEtudians_AnneAcademique_Niveau, Integer>("id"));
         Cmatricule.setCellValueFactory(new PropertyValueFactory<MEtudians_AnneAcademique_Niveau, String>("matri"));
         CannAcEtu.setCellValueFactory(new PropertyValueFactory<MEtudians_AnneAcademique_Niveau,String>("anneac"));
         Cniveau.setCellValueFactory(new PropertyValueFactory<MEtudians_AnneAcademique_Niveau,String>("niveau"));
    
         for(MEtudians_AnneAcademique_Niveau mde : listetan){
             
             datatable.add(mde);
            
         }
         
         tabannAcEtu.setItems(datatable);
         
         tabannAcEtu.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> affichAnnEtu(newValue));  
    
    }
    
    
    
}
