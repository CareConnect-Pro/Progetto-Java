package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio;

public class ParametroVitale {
    private TipiParametroVitale parametroVitale;
    private int valore;


    public ParametroVitale(TipiParametroVitale parametroVitale, int valore) {
        this.parametroVitale = parametroVitale;
        this.valore = valore;

    }

    public TipiParametroVitale getParametroVitale() {return parametroVitale;}
    public void setParametroVitale(TipiParametroVitale parametroVitale) {this.parametroVitale = parametroVitale;}
    public int getValore() {return valore;}
    public void setValore(int valore) {this.valore = valore;}
    
}
