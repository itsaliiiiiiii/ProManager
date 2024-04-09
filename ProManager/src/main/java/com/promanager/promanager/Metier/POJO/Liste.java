package com.promanager.promanager.Metier.POJO;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class Liste {
    private ObjectId idListe;
    private String nomListe;
    private String descriptionListe;
    ArrayList<ObjectId> ListeTache;

    public Liste() {
        ListeTache = new ArrayList<>();
    }
    
    public Liste(ObjectId idListe, String nomListe, String descriptionListe) {
        this.idListe = idListe;
        this.nomListe = nomListe;
        this.descriptionListe = descriptionListe;
        ListeTache = new ArrayList<>();
    }
    public Liste( String nomListe, String descriptionListe) {
        this.nomListe = nomListe;
        this.descriptionListe = descriptionListe;
    }

    public ObjectId getIdListe() {
        return idListe;
    }

    public void setIdListe(ObjectId idListe) {
        this.idListe = idListe;
    }

    public String getNomListe() {
        return nomListe;
    }

    public void setNomListe(String nomListe) {
        this.nomListe = nomListe;
    }

    public String getDescriptionListe() {
        return descriptionListe;
    }

    public void setDescriptionListe(String descriptionListe) {
        this.descriptionListe = descriptionListe;
    }

    public ArrayList<ObjectId> getListeTache() {
        return ListeTache;
    }

    public void setListeTache(ArrayList<ObjectId> listeTache) {
        ListeTache = listeTache;
    }
}