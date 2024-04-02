package com.promanager.promanager.Metier.POJO;

import java.util.Date;

public class Tache {
    private String idTache;
    private String categorieTache;
    private String descriptionTache;
    private Date dateDepartTache;
    private Date dateFinTache;

    public Tache() {
    }

    public Tache(
            String idTache, String categorieTache, String descriptionTache, Date dateDepartTache,
            Date dateFinTache) {
        this.idTache = idTache;
        this.categorieTache = categorieTache;
        this.descriptionTache = descriptionTache;
        this.dateDepartTache = dateDepartTache;
        this.dateFinTache = dateFinTache;
    }

    public String getIdTache() {
        return idTache;
    }

    public void setIdTache(String idTache) {
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

}
