package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class LoginController {

    private ViewController view;
    private IRSA rsa;
    private GoBtnActionListener go;

    public LoginController (IRSA rsa, ViewController view) {
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
