package com.promanager.promanager.Metier.POJO;

public class Document_ {
    private String idDocument;
    private String pathDocument;
    private String descriptionDocument;

    public Document_() {
    }

    public Document_(String idDocument, String pathDocument, String descriptionDocument) {
        this.idDocument = idDocument;
        this.pathDocument = pathDocument;
        this.descriptionDocument = descriptionDocument;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
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
