package it.unipv.posw.careconnectpro.model.rsa.login;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;

public class ProxyLogin implements IRSALogin {
    
    private IRSALogin rsa;
    private static ProxyLogin proxy;

    private ProxyLogin() { 
    	this.rsa = new LoginService();
    }

    public static ProxyLogin getProxy() {
        if (proxy == null) {
            proxy = new ProxyLogin();
        }
        return proxy;
    }

    @Override
    public Dipendente login(String cf, String pw) {
        return rsa.login(cf, pw);
    }
    
    @Override
    public Dipendente getUtenteLoggato() {
        return GestoreSessione.getIstanza().getUtenteLoggato();
    }
}