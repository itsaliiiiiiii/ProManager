package com.promanager.promanager.Metier.POJO;

import java.util.Date;

import org.bson.types.ObjectId;

public class Document_ {
    private ObjectId idDocument;
    private String pathDocument;
    private String descriptionDocument;
    private Date dateAjout;

    public Document_() {
    }

    public Document_(ObjectId idDocument, String pathDocument, String descriptionDocument,Date dateAjout) {
        this.idDocument = idDocument;
        this.pathDocument = pathDocument;
        this.descriptionDocument = descriptionDocument;
        this.dateAjout=dateAjout;
    }
    public Document_( String pathDocument, String descriptionDocument,Date dateAjout) {
        this.pathDocument = pathDocument;
        this.descriptionDocument = descriptionDocument;
        this.dateAjout=dateAjout;
    }
    
    public ObjectId getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(ObjectId idDocument) {
        this.idDocument = idDocument;
    }

    public String getPathDocument() {
        return pathDocument;
    }

    public void setPathDocument(String pathDocument) {
        this.pathDocument = pathDocument;
    }

    public String getDescriptionDocument() {
        return descriptionDocument;
    }

    public void setDescriptionDocument(String descriptionDocument) {
        this.descriptionDocument = descriptionDocument;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

}
