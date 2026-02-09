package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

public class LoginController {

    private ViewController view;
    private RSAService rsa;
    private GoBtnActionListener go;

    public LoginController (RSAService rsa, ViewController view) {
        this.view = view;
        this.rsa = rsa;

        go = new GoBtnActionListener(view, rsa);
        view.getLoginPanel().getLoginButton().addActionListener(go);

        addlogoutActionListener();

    }

    private void addlogoutActionListener(){
        LogoutActionListener logout = new LogoutActionListener(rsa, view);
        view.getAmmPanel().getLogoutButton().addActionListener(logout);
        view.getMedPanel().getLogoutButton().addActionListener(logout);
        view.getInfPanel().getLogoutButton().addActionListener(logout);
    }
}
