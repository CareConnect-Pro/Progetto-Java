package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;

public class Main {
    public static void main() {
        RSAService model = new RSAService();
        ViewController viewController = new ViewController();
        new FacadeController(model, viewController);

//        viewController.getLoginPanel();
//        viewController.setVisible(true);



    }
}
