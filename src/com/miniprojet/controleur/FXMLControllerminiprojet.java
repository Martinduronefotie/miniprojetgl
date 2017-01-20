/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.controleur;

import com.miniprojet.Dao.ThemesDao;
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
public class FXMLControllerminiprojet implements Initializable {
     private Theme thglobal  = new Theme();
    //text
    @FXML
    private TextField textTheme;
    //buttton
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsuppth;
     @FXML
    private Button btnTheme;
    //tabview
    @FXML
    private TableView<Theme> tabtheme;
    @FXML
    private TableColumn<Theme, Integer> Cid;
    @FXML
    private TableColumn<Theme, String> Cnomthemes;
    @FXML
    private TableColumn<Theme, String> Cetatheme;

    final ObservableList<Theme> data = FXCollections.observableArrayList();

    @FXML
    public void SaveTheme(ActionEvent event) throws IOException {

        if (textTheme.getText().equals("")) {

        } else {

            Theme th = new Theme(textTheme.getText(),"");

            ThemesDao thdao = new ThemesDao();

            thdao.ajouterTheme(th);
            
            List<Theme> list = new ArrayList<Theme>();
            list = thdao.AllThemes();
        
         for (Theme etd : list) {

               th = etd;

        }
        data.add(th);
        tabtheme.setItems(data);

           

        }

    }

    @FXML
    public void ModiThemes(ActionEvent event) throws IOException {
        
        btnTheme.setDisable(false);
        btnmodifier.setDisable(true);
        btnsuppth.setDisable(true);
          
         ThemesDao thdao = new ThemesDao();
         thglobal.setLibelle(textTheme.getText());
         thdao.updateTheme(thglobal,thglobal.getId());
         // thdao.updateTheme(th,thglobal.getId());
           data.clear();
          List<Theme> list = new ArrayList<Theme>();
          list = thdao.AllThemes();

        Cid.setCellValueFactory(new PropertyValueFactory<Theme, Integer>("id"));
        Cnomthemes.setCellValueFactory(new PropertyValueFactory<Theme, String>("libelle"));
        Cetatheme.setCellValueFactory(new PropertyValueFactory<Theme, String>("etat_theme"));
        for (Theme etd : list) {

            data.add(etd);

        }
        tabtheme.setItems(data);
         textTheme.setText("");
         textTheme.setText("");

    }

    @FXML
    public void suppThemes(ActionEvent event) throws IOException {
        
         btnTheme.setDisable(false);
         btnmodifier.setDisable(true);
         btnsuppth.setDisable(true);
         
          ThemesDao thdao = new ThemesDao();
          thdao.deleteTheme(thglobal.getId());
          
          data.clear();
          List<Theme> list = new ArrayList<Theme>();
          list = thdao.AllThemes();

        Cid.setCellValueFactory(new PropertyValueFactory<Theme, Integer>("id"));
        Cnomthemes.setCellValueFactory(new PropertyValueFactory<Theme, String>("libelle"));
        Cetatheme.setCellValueFactory(new PropertyValueFactory<Theme, String>("etat_theme"));
        for (Theme etd : list) {

            data.add(etd);

        }
        tabtheme.setItems(data);
          textTheme.setText("");
        


    }
    
    
    
    
    public  void affichetheme(Theme th){
        
        if(th!=null){
            
            btnmodifier.setDisable(false);
            btnsuppth.setDisable(false);
            textTheme.setText(th.getLibelle());
            btnTheme.setDisable(true);
            
            thglobal.setEtat_theme(th.getEtat_theme());
            thglobal.setId(th.getId());
            thglobal.setLibelle(th.getLibelle());
            
            
              
        }
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnmodifier.setDisable(true);
        btnsuppth.setDisable(true);

        ThemesDao thdao = new ThemesDao();
        List<Theme> list = new ArrayList<Theme>();
        list = thdao.AllThemes();

        Cid.setCellValueFactory(new PropertyValueFactory<Theme, Integer>("id"));
        Cnomthemes.setCellValueFactory(new PropertyValueFactory<Theme, String>("libelle"));
        Cetatheme.setCellValueFactory(new PropertyValueFactory<Theme, String>("etat_theme"));
        for (Theme etd : list) {

            data.add(etd);

        }
        tabtheme.setItems(data);
        
        
        
        
        tabtheme.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> affichetheme(newValue));
    }

}
