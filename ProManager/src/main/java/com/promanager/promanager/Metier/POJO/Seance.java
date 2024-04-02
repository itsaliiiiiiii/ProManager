package com.promanager.promanager.Metier.POJO;

import java.util.Calendar;

public class Seance {
    private String idSeance;
    private String descriptionSeance;
    private Calendar dateDepartSeance;
    private Calendar dateFinSeance;
    private String note;

    public Seance() {
    }

    public Seance(
            String idSeance, String descriptionSeance, Calendar dateDepartSeance, Calendar dateFinSeance,
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

    public Calendar getDateDepartSeance() {
        return dateDepartSeance;
    }

    public void setDateDepartSeance(Calendar dateDepartSeance) {
        this.dateDepartSeance = dateDepartSeance;
    }

    public Calendar getDateFinSeance() {
        return dateFinSeance;
    }

    public void setDateFinSeance(Calendar dateFinSeance) {
        this.dateFinSeance = dateFinSeance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
