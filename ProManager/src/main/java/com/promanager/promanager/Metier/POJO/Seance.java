package com.promanager.promanager.Metier.POJO;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

public class Seance {
    private ObjectId idSeance;
    private String descriptionSeance;
    private Date dateDepartSeance;
    private Date dateFinSeance;
    private String note;
    ArrayList<ObjectId> ListeDocument;

    public Seance() {
        ListeDocument = new ArrayList<>();
    }

    public Seance(
            ObjectId idSeance, String descriptionSeance, Date dateDepartSeance, Date dateFinSeance,
            String note) {
        this.idSeance = idSeance;
        this.descriptionSeance = descriptionSeance;
        this.dateDepartSeance = dateDepartSeance;
        this.dateFinSeance = dateFinSeance;
        this.note = note;
        ListeDocument = new ArrayList<>();
    }

    public Seance(
            String descriptionSeance, Date dateDepartSeance, Date dateFinSeance,
            String note) {
        this.descriptionSeance = descriptionSeance;
        this.dateDepartSeance = dateDepartSeance;
        this.dateFinSeance = dateFinSeance;
        this.note = note;
        ListeDocument = new ArrayList<>();
    }

    public ObjectId getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(ObjectId idSeance) {
        this.idSeance = idSeance;
    }

    public String getDescriptionSeance() {
        return descriptionSeance;
    }

    public void setDescriptionSeance(String descriptionSeance) {
        this.descriptionSeance = descriptionSeance;
    }

    public Date getDateDepartSeance() {
        return dateDepartSeance;
    }

    public void setDateDepartSeance(Date dateDepartSeance) {
        this.dateDepartSeance = dateDepartSeance;
    }

    public Date getDateFinSeance() {
        return dateFinSeance;
    }

    public void setDateFinSeance(Date dateFinSeance) {
        this.dateFinSeance = dateFinSeance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<ObjectId> getListeDocument() {
        return ListeDocument;
    }

    public void setListeDocument(ArrayList<ObjectId> listeDocument) {
        ListeDocument = listeDocument;
    }

}
