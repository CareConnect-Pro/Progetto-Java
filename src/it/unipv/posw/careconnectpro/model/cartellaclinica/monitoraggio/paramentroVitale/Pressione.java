package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale;

public class Pressione {
    int [] pressione;
    int sistolica, diastolica;

    public Pressione(String valore){
        String[] pressione = valore.split("/");
        sistolica = Integer.parseInt(pressione[0].trim());
        diastolica = Integer.parseInt(pressione[1].trim());

    }


    public boolean isCritica(){
        if (sistolica >= 140 && diastolica > 100){
            return true;
        }
        return false;
    }

    public int getSistolica() {
        return sistolica;
    }

    public int getDiastolica() {
        return diastolica;
    }
}
