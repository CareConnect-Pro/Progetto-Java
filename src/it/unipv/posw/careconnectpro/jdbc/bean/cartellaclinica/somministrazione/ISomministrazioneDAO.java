package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.somministrazione;

import java.util.List;

public interface ISomministrazioneDAO {

    int insertSomministrazione(SomministrazioneDB sDb);
    List<SomministrazioneDB> selectSomministrazioniByPaziente(String cfPaziente);
    List<SomministrazioneDB> selectSomministrazioniByStato(String stato);
    List<SomministrazioneDB> selectAllSomministrazioni();
    boolean updateSomministrazione(SomministrazioneDB sDb);
    
}