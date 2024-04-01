package com.promanager.promanager.Metier.POJO;

import java.util.Date;

public class Projet {
    private Integer idProjet;
    private String categorieProjet;
    private String typeProjet;
    private String descriptionProjet;
    private Date dateDepartProjet;
    private Date dateFinProjet;

    public Projet() {
    }

    public Projet(Integer idProjet, String categorieProjet, String typeProjet, String descriptionProjet,
            Date dateDepartProjet, Date dateFinProjet) {
        this.idProjet = idProjet;
        this.categorieProjet = categorieProjet;
        this.typeProjet = typeProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDepartProjet = dateDepartProjet;
        this.dateFinProjet = dateFinProjet;
    }

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
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
        return "Projet : idProjet=" + idProjet + ", categorieProjet=" + categorieProjet + ", typeProjet=" + typeProjet
                + ", descriptionProjet=" + descriptionProjet + ", dateDepartProjet=" + dateDepartProjet
                + ", dateFinProjet=" + dateFinProjet;
    }

}