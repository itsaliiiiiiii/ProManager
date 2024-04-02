package com.promanager.promanager.Metier.POJO;

public class Liste {
    private String idListe;
    private String nomListe;
    private String descriptionListe;

    public Liste() {
    }

    public Liste(String idListe, String nomListe, String descriptionListe) {
        this.idListe = idListe;
        this.nomListe = nomListe;
        this.descriptionListe = descriptionListe;
    }

    public String getIdListe() {
        return idListe;
    }

    public void setIdListe(String idListe) {
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

}
