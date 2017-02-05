/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniprojet.Dao;

import com.miniprojet.model.Encadrement;
import com.miniprojet.model.Enseignant;
import com.miniprojet.model.Theme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author durone
 */
public class EncadrementDao extends Dao {

    private boolean reponse;

    private ResultSet rs;
    private PreparedStatement pst;

    public EncadrementDao() {
        super();

    }

    /**
     * cette methode permet d'ajouter un encadrement dans la bd
     *
     * @param enc (elle represente un encadrement )
     */
    public void ajouterEncar(Encadrement enc) {

        try {

            pst = super.getCon().prepareStatement("INSERT INTO encadrement VALUES(?,?,?,?,?)");
            pst.setInt(1,0);
            pst.setInt(2, enc.getTheme().getId());
            pst.setInt(3, enc.getEnseignant().getId_enseignant());
            pst.setString(4, enc.getType_encadrement());
            pst.setString(5,"cree");
            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * suppression d'une Encadrement
     *
     * @param id (identifiant de l encadrement )
     */
    public void deleteEncadrement(int id) {
        try {
            pst = super.getCon().prepareStatement("DELETE FROM encadrement WHERE id_encadrement = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * mise a jour d'un encadrement
     *
     * @param spc ( representer l ' encadrement a metre a jour )
     */
    public void updateEncadrement(Encadrement enc) {
        try {

            pst = super.getCon().prepareStatement("UPDATE encadrement SET themes_id_theme =?,enseignant_id_enseignant =?,type_encadrement =?,etat_encadrement =?  WHERE id_encadrement =?");
            pst.setInt(1, enc.getTheme().getId());

            pst.setInt(2, enc.getEnseignant().getId_enseignant());
            pst.setString(3,enc.getType_encadrement());
            pst.setString(4,enc.getEta_encadrement());
            pst.setInt(5, enc.getId_encadremet());

            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * cette methode permet d'avoir tous les encadrement presents dans la bd
     *
     * @return une list de type "ArrayList<Encadrement>"
     */
    public List<Encadrement> Allencadrement() {
        List<Encadrement> listencadrement = new ArrayList<Encadrement>();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant and etat_encadrement='cree' ");
            rs = pst.executeQuery();
            while (rs.next()) {
                Encadrement encadre = new Encadrement();
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));

                 //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

                listencadrement.add(encadre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listencadrement;
    }
    
    
     public List<Encadrement> Allencadrementencours() {
        List<Encadrement> listencadrement = new ArrayList<Encadrement>();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant and etat_encadrement!='cree' ");
            rs = pst.executeQuery();
            while (rs.next()) {
                Encadrement encadre = new Encadrement();
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));

                 //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

                listencadrement.add(encadre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listencadrement;
    }

    /**
     * cette methode permet de recupere un encadrement par son identifiant
     *
     * @param id(represent l identifaint de l'encadrement)
     * @return Encadrement
     */
    public Encadrement recupUnEncadrement(int id) {

        Encadrement encadre = new Encadrement();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where id_encadrement=? and themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));
                //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encadre;
    }
    
     public Encadrement recupUnEncadrementencours(int id) {

        Encadrement encadre = new Encadrement();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where id_encadrement=? and etat_encadrement=? and themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant");
            pst.setInt(1, id);
            pst.setString(2,"encours");
            rs = pst.executeQuery();
            while (rs.next()) {
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));
                //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encadre;
    }
     
     public Encadrement recupUnEncadrementnote(int id) {

        Encadrement encadre = new Encadrement();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where id_encadrement=? and themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));
                //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encadre;
    }

    /**
     * cette methode permet d'avoir tous les encadrement deja effectue presents
     * dans la bd
     *
     * @return une list de type "ArrayList<Encadrement>"
     */
    public List<Encadrement> AllencdrementEffctue() {
        List<Encadrement> listencadrement = new ArrayList<Encadrement>();

        try {

            pst = super.getCon().prepareStatement("SELECT * FROM encadrement,themes,enseignant where etat_encadrement=? and themes_id_theme=id_theme and enseignant_id_enseignant=id_enseignant");
            pst.setString(1, "effectue");
            rs = pst.executeQuery();
            while (rs.next()) {
                Encadrement encadre = new Encadrement();
                //recuperation des info sur un themes
                Theme th = new Theme();
                th.setId(rs.getInt("id_theme"));
                th.setLibelle(rs.getString("libelle_theme"));
                th.setEtat_theme(rs.getString("etat_theme"));
                //recupration des info sur un enseignant

                Enseignant ens = new Enseignant();

                ens.setId_enseignant(rs.getInt("enseignant_id_enseignant"));

                 //infomartion encadrement
                encadre.setId_encadremet(rs.getInt("id_encadrement"));
                encadre.setType_encadrement(rs.getString("type_encadrement"));
                encadre.setEta_encadrement(rs.getString("etat_encadrement"));
                encadre.setEnseignant(ens);
                encadre.setTheme(th);

                listencadrement.add(encadre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listencadrement;
    }

}
