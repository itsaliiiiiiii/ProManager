package com.promanager.promanager.Metier.POJO;

import org.bson.types.ObjectId;

public class Document_ {
    private ObjectId idDocument;
    private String pathDocument;
    private String descriptionDocument;

    public Document_() {
    }

    public Document_(ObjectId idDocument, String pathDocument, String descriptionDocument) {
        this.idDocument = idDocument;
        this.pathDocument = pathDocument;
        this.descriptionDocument = descriptionDocument;
    }
    public Document_( String pathDocument, String descriptionDocument) {
        this.pathDocument = pathDocument;
        this.descriptionDocument = descriptionDocument;
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

}
