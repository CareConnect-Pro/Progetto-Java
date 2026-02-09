package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;

public class Main {
    public static void main(String[] args) {
        IRSA model = ProxyRSA.getProxy();
        ViewController viewController = new ViewController();
        new FacadeController(model, viewController);

    }
}
