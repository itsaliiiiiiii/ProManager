package com.promanager.promanager.Metier.POJO;

import java.util.Date;

public class Projet {
    private String idProjet;
    private String categorieProjet;
    private String typeProjet;
    private String descriptionProjet;
    private Date dateDepartProjet;
    private Date dateFinProjet;

    public Projet() {
    }

    public Projet(
            String idProjet, String categorieProjet, String typeProjet, String descriptionProjet,
            Date dateDepartProjet, Date dateFinProjet) {
        this.idProjet = idProjet;
        this.categorieProjet = categorieProjet;
        this.typeProjet = typeProjet;
        this.descriptionProjet = descriptionProjet;
        this.dateDepartProjet = dateDepartProjet;
        this.dateFinProjet = dateFinProjet;
    }

    public String getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(String idProjet) {
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
}