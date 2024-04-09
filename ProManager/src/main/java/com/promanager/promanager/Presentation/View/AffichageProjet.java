package com.promanager.promanager.Presentation.View;

import org.bson.types.ObjectId;

import javafx.scene.layout.AnchorPane;

public class AffichageProjet extends AnchorPane {
    private ObjectId idProjet;

    public AffichageProjet(ObjectId id) {
        idProjet = id;
    }

}