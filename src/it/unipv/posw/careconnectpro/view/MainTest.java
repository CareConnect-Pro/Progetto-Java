package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;

public class MainTest {

	public static void main(String[] args) {
		
			
	
				RSAService model = new RSAService() ;
				ViewController view = new ViewController();
				
				FacadeController facade = new FacadeController(model, view);
						
				
			}

	}

