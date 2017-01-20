/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.miniprojet.Dao;

import com.miniprojet.model.Encadrement;
import com.miniprojet.model.Enseignant;
import com.miniprojet.model.MEtudians_AnneAcademique_Niveau;
import com.miniprojet.model.ModelAnneAcademique;
import com.miniprojet.model.ModelEtudiants;
import com.miniprojet.model.Niveau;
import com.miniprojet.model.Specialiter;
import com.miniprojet.model.Theme;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author durone
 */
public class MINIPROJET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //test theme 
        
        Theme th = new Theme("ma","film");
       // th.setId(7);
        ThemesDao thdao = new ThemesDao();
        //thdao.ajouterTheme(th);
        
        //thdao.deleteTheme(2);
         thdao.updateTheme(th,7);
         List<Theme> list = new ArrayList<Theme>();
         list=thdao.AllThemes();
         /*  for( Theme etd :list){
          
          System.out.println(etd.getId());
          System.out.println(etd.getLibelle());
          System.out.println(etd.getEtat_theme());
          
      }*/
         
   //test enseignant
         
         EnseignantDAO ensDAO= new EnseignantDAO();
         Enseignant es = new Enseignant("durone","durone");
         es.setId_enseignant(2);
         String st= ensDAO.connect(es);
         System.out.println(st);
         
   // test encadrement 
         
         EncadrementDao encDao = new EncadrementDao();
         Encadrement enc = new Encadrement(th, es,"type2", "");
         enc.setId_encadremet(1);
         //encDao.ajouterEncar(enc);
         
        // encDao.deleteEncadrement(3);
         
        //enc= encDao.recupUnEncadrement(1);
        
        
        enc.getTheme().getLibelle();
        System.out.println(enc.getEnseignant().getLogin());
         System.out.println( enc.getTheme().getEtat_theme());
         
         List<Encadrement> listen= new ArrayList<Encadrement>();
         listen = encDao.Allencadrement();
         
  // test speciliter
         
         SpecialiterDao  spdao = new SpecialiterDao();
         Specialiter spc = new Specialiter("lccc");
         spc.setIspecialiter(3);
         spc.setIspecialiter(2);
       //  spdao.ajouterSpecialiter(spc);
        // spdao.deleteSpecialiter(1);
        // spdao.updateSpecialiter(spc);
         List<Specialiter> listsp = new ArrayList<Specialiter>();
         listsp= spdao.AllSpecialiter();
         
         for(Specialiter sp :listsp){
            // System.out.println(sp.getLibelle());
           //  System.out.println(sp.getIdspecialiter());
             
         }
         
         spdao.oneSpecialiter(3);
         
  // test niveau
         
         NiveauDao nivdao = new NiveauDao();
         Niveau niveau = new Niveau("libelle",spc);
         niveau.setId_niveau(1);
        // nivdao.ajouterniveau(niveau);
        // nivdao.deleteniveau(2);
         List<Niveau> lisniv = new ArrayList<Niveau>();
         lisniv=nivdao.AllNiveau();
         
         for(Niveau niv : lisniv){
             
             //System.out.println(niv.getSpecialiter().getIdspecialiter());
             //System.out.println(niv.getSpecialiter().getLibelle());
             
         }
         
        niveau=nivdao.recupereUnNiveau(5);
        
        //System.out.println(niveau.getSpecialiter().getIdspecialiter());
       // System.out.println(niveau.getSpecialiter().getLibelle());
        
 //test Etudiants
        
        ModelEtudiants etudiant = new ModelEtudiants("iut", enc,"martin","durone",0.0);
        
        etudiant.setIdetudiants("iut162497064");
        
        EtudiantsDao etdao = new EtudiantsDao();
        //etdao.ajouterETudiants(etudiant);
        //etdao.deleteEtd("iut162497063");
        //etudiant= etdao.recupUnEtudiants("iut162497064");
        //System.out.println(etudiant.getNom());
        //System.out.println(etudiant.getEncadrement().getTheme().getLibelle());
        List<ModelEtudiants> liustetd= new ArrayList<ModelEtudiants>();
        
         liustetd=  etdao.recupAllEtudiants();
        
   // test annes academiques
         
         AnneAcademiqueDao anndao = new AnneAcademiqueDao();
         
         ModelAnneAcademique ann = new ModelAnneAcademique("2016-2017");
         ann.setId_anne_accademiques(1);
         
         List<ModelAnneAcademique> listann= new ArrayList<ModelAnneAcademique>();
         
        // anndao.ajouteAnneAcd(ann);
        // anndao.recuperUneAnneAcademique(1);
        // listann=  anndao.Allniveau();
        // anndao.deleteAnneAcd(1);
         
   // test etudians_année academiques
         
         MEtudians_AnneAcademique_Niveau mean = new MEtudians_AnneAcademique_Niveau(etudiant, ann, niveau);
         Etudians_AnneAcademique_NiveauDao dao = new Etudians_AnneAcademique_NiveauDao();
         
         //dao.saveEtAnnN(mean);
         
         dao.deleteEtAnnN(1);
         
         
         
         
         
   }
    
}
