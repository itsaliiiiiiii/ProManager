package com.promanager.promanager.Metier.POJO;


import java.util.Date;

public class Seance {
    private String idSeance;
    private String descriptionSeance;
    private java.util.Date dateDepartSeance;
    private Date dateFinSeance;
    private String note;

    public Seance() {
    }

    public Seance(
            String idSeance, String descriptionSeance, Date dateDepartSeance, Date dateFinSeance,
            String note) {
        this.idSeance = idSeance;
        this.descriptionSeance = descriptionSeance;
        this.dateDepartSeance = dateDepartSeance;
        this.dateFinSeance = dateFinSeance;
        this.note = note;
    }

    public String getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(String idSeance) {
        this.idSeance = idSeance;
    }

    public String getDescriptionSeance() {
        return descriptionSeance;
    }

    public void setDescriptionSeance(String descriptionSeance) {
        this.descriptionSeance = descriptionSeance;
    }

    public java.util.Date getDateDepartSeance() {
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

}
