package it.unipv.posw.careconnectpro.model.parametri.diaro;

import java.util.ArrayList;
import java.util.List;

public class DiarioParametri {
	
	private String idDiarioParametri;
	private String idPaziente;
	
    //private String idDiario;
    private List<Monitoraggio> monitoraggi;
    private static final int LUNGHEZZA = 10;

    public DiarioParametri(String idPaziente) {
        this.idDiarioParametri =  idDiarioParametri;
        this.monitoraggi = new ArrayList<>();
        this.idPaziente = idPaziente;
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
    public String getIdDiarioParametri() {
        return idDiarioParametri;
    }
    public void setIdDiario(String idDiario) { this.idDiarioParametri = idDiario;}

    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }

	public String getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(String idPaziente) {
		this.idPaziente = idPaziente;
	}

    

}
