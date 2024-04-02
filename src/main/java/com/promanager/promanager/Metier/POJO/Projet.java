package com.promanager.promanager.Metier.POJO;

import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Projet {
    private ObjectId idProjet;
    private String categorieProjet;
    private String typeProjet;
    private String descriptionProjet;
    private Date dateDepartProjet;
    private Date dateFinProjet;

    ArrayList<Tache> ListeTaches;
    ArrayList<Document_> ListeDocuments;
    ArrayList<Seance> ListeSeances;

    public Projet() {
        ListeTaches=new ArrayList<>();
        ListeDocuments = new ArrayList<>();
        ListeSeances = new ArrayList<>();
    }

    public Projet(ObjectId idProjet, String categorieProjet, String typeProjet, String descriptionProjet, Date dateDepartProjet, Date dateFinProjet) {
        this.idProjet = idProjet;
        this.categorieProjet = categorieProjet;
        this.typeProjet = typeProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDepartProjet = dateDepartProjet;
        this.dateFinProjet = dateFinProjet;
    }

    public Projet(
             String categorieProjet, String typeProjet, String descriptionProjet,
            Date dateDepartProjet, Date dateFinProjet) {
        this.categorieProjet = categorieProjet;
        this.typeProjet = typeProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDepartProjet = dateDepartProjet;
        this.dateFinProjet = dateFinProjet;
        ListeTaches=new ArrayList<>();
        ListeDocuments = new ArrayList<>();
        ListeSeances = new ArrayList<>();
    }

    public ObjectId getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(ObjectId idProjet) {
        this.idProjet = idProjet;
    }

    public String getCategorieProjet() {
        return categorieProjet;
    }

    public void setCategorieProjet(String categorieProjet) {
        this.categorieProjet = categorieProjet;
    }

    public String getTypeProjet() {
        return typeProjet;
    }

    public void setTypeProjet(String typeProjet) {
        this.typeProjet = typeProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public Date getDateDepartProjet() {
        return dateDepartProjet;
    }

    public void setDateDepartProjet(Date dateDepartProjet) {
        this.dateDepartProjet = dateDepartProjet;
    }

    public Date getDateFinProjet() {
        return dateFinProjet;
    }

    public void setDateFinProjet(Date dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    @Override
    public String toString() {
        return "Projet :\n   idProjet = " + idProjet + "\n" +
                "   categorieProjet = " + categorieProjet + "\n" +
                "   typeProjet = " + typeProjet + "\n" +
                "   descriptionProjet = " + descriptionProjet + "\n" +
                "   dateDepartProjet = " + dateDepartProjet + "\n" +
                "   dateFinProjet = " + dateFinProjet;
    }

    public ArrayList<Tache> getListeTaches() {
        return ListeTaches;
    }

    public void setListeTaches(ArrayList<Tache> listeTaches) {
        ListeTaches = listeTaches;
    }

    public ArrayList<Document_> getListeDocuments() {
        return ListeDocuments;
    }

    public void setListeDocuments(ArrayList<Document_> listeDocuments) {
        ListeDocuments = listeDocuments;
    }

    public ArrayList<Seance> getListeSeances() {
        return ListeSeances;
    }

    public void setListeSeances(ArrayList<Seance> listeSeances) {
        ListeSeances = listeSeances;
    }
}