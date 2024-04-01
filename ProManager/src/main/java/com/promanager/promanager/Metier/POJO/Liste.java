package com.promanager.promanager.Metier.POJO;

import java.util.Calendar;

public class Liste {
    private Integer idListe;
    private String nomListe;
    private Calendar descriptionListe;

    public Liste() {
    }

    public Liste(Integer idListe, String nomListe, Calendar descriptionListe) {
        this.idListe = idListe;
        this.nomListe = nomListe;
        this.descriptionListe = descriptionListe;
    }

    public Integer getIdListe() {
        return idListe;
    }

    public void setIdListe(Integer idListe) {
        this.idListe = idListe;
    }

    public String getNomListe() {
        return nomListe;
    }

    public void setNomListe(String nomListe) {
        this.nomListe = nomListe;
    }

    public Calendar getDescriptionListe() {
        return descriptionListe;
    }

    public void setDescriptionListe(Calendar descriptionListe) {
        this.descriptionListe = descriptionListe;
    }

}
