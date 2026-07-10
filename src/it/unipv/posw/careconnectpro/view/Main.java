package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.model.rsa.login.ProxyLogin;
import it.unipv.posw.careconnectpro.model.rsa.login.IRSALogin;

public class Main {
    public static void main(String[] args) {
        IRSALogin model = ProxyLogin.getProxy();
        ViewController viewController = new ViewController();
        new FacadeController(model, viewController);
    }
}