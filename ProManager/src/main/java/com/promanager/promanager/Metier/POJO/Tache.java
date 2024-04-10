package com.promanager.promanager.Metier.POJO;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

public class Tache {
    private ObjectId idTache;
    private String categorieTache;
    private String descriptionTache;
    private Date dateDepartTache;
    private Date dateFinTache;
    ArrayList<ObjectId> ListeDocument;

    public Tache() {
        ListeDocument = new ArrayList<>();
    }

    public Tache(
            ObjectId idTache, String categorieTache, String descriptionTache, Date dateDepartTache,
            Date dateFinTache) {
        this.idTache = idTache;
        this.categorieTache = categorieTache;
        this.descriptionTache = descriptionTache;
        this.dateDepartTache = dateDepartTache;
        this.dateFinTache = dateFinTache;
        ListeDocument = new ArrayList<>();

    }

    public Tache(
            String categorieTache, String descriptionTache, Date dateDepartTache,
            Date dateFinTache) {
        this.categorieTache = categorieTache;
        this.descriptionTache = descriptionTache;
        this.dateDepartTache = dateDepartTache;
        this.dateFinTache = dateFinTache;
        ListeDocument = new ArrayList<>();

    }

    public ObjectId getIdTache() {
        return idTache;
    }

    public void setIdTache(ObjectId idTache) {
        this.idTache = idTache;
    }

    public String getCategorieTache() {
        return categorieTache;
    }

    public void setCategorieTache(String categorieTache) {
        this.categorieTache = categorieTache;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public Date getDateDepartTache() {
        return dateDepartTache;
    }

    public void setDateDepartTache(Date dateDepartTache) {
        this.dateDepartTache = dateDepartTache;
    }

    public Date getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(Date dateFinTache) {
        this.dateFinTache = dateFinTache;
    }

    public ArrayList<ObjectId> getListeDocument() {
        return ListeDocument;
    }

    public void setListeDocument(ArrayList<ObjectId> listeDocument) {
        ListeDocument = listeDocument;
    }

}
