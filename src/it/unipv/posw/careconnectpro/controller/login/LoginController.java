package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.rsa.login.IRSALogin;
import it.unipv.posw.careconnectpro.view.ViewController;

public class LoginController {

    private ViewController view;
    private GoBtnActionListener go;

    public LoginController (IRSALogin rsa, ViewController view) {
        this.view = view;

        go = new GoBtnActionListener(view, rsa);
        view.getLoginPanel().getLoginButton().addActionListener(go);

        addlogoutActionListener();
    }

    private void addlogoutActionListener(){
        LogoutActionListener logout = new LogoutActionListener(view);
        view.getAmmPanel().getLogoutButton().addActionListener(logout);
        view.getMedPanel().getLogoutButton().addActionListener(logout);
        view.getInfPanel().getLogoutButton().addActionListener(logout);
    }
}