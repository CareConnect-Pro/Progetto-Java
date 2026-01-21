package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio;

public class ParametroVitale {
    private TipiParametroVitale parametroVitale;
    private int valore;
    private String stato;

    public ParametroVitale(TipiParametroVitale parametroVitale, int valore, String stato) {
        this.parametroVitale = parametroVitale;
        this.valore = valore;
        this.stato = stato;
    }

    public TipiParametroVitale getParametroVitale() {return parametroVitale;}
    public void setParametroVitale(TipiParametroVitale parametroVitale) {this.parametroVitale = parametroVitale;}
    public int getValore() {return valore;}
    public void setValore(int valore) {this.valore = valore;}
    public String getStato() {return stato;}
    public void setStato(String stato) {this.stato = stato;}
    
}
