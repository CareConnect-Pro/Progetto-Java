package it.unipv.posw.careconnectpro.model.parametri.diaro;

import java.security.SecureRandom;

public class GeneratoreId {
    private static final String CARATTERI = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();

    public static String id(int lunghezza){
        if (lunghezza < 1){
            throw new IllegalArgumentException("Lunghezza non valido.");
        }
        StringBuilder sb = new StringBuilder(lunghezza);

        for(int i=0;i<lunghezza;i++){
            sb.append(CARATTERI.charAt(random.nextInt(CARATTERI.length())));
        }
        return sb.toString();
    }
}
