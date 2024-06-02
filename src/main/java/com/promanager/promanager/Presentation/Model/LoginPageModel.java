package com.promanager.promanager.Presentation.Model;

import com.promanager.promanager.Persistance.DAOconfiguration;

public class LoginPageModel {
    private DAOconfiguration config;

    public LoginPageModel() {
        config = new DAOconfiguration();
    }

    public boolean isGoogleMail(String email) {
        return email.endsWith("@gmail.com");
    }

    public void insertMail(String email) {
        config.insertMail(email);

    }

}
