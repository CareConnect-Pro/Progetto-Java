package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;

public class Main {
    public static void main(String[] args) {
        RSAService model = new RSAService();
        ViewController viewController = new ViewController();
        new FacadeController(model, viewController);





    }
}
