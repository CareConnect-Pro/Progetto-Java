package it.unipv.posw.careconnectpro.model.parametri.diaro;

import java.util.ArrayList;
import java.util.List;

public class DiarioParamentri {
    private String idDiario;
    private List<Monitoraggio> monitoraggi;
    private static final int LUNGHEZZA = 10;

    public DiarioParamentri() {
        this.idDiario =  idDiario;
        this.monitoraggi = new ArrayList<>();
    }

    public void addMonitoraggi(Monitoraggio m){
        this.monitoraggi.add(m);
    }
    public List<Monitoraggio> getMonitoraggi() {
        return monitoraggi;
    }
    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {
        this.monitoraggi = monitoraggi;
    }
    public String getIdDiario() {
        return idDiario;
    }
    public void setIdDiario(String idDiario) { this.idDiario = idDiario;}

    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }



}
