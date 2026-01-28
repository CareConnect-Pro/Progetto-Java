package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import java.util.List;

import it.unipv.posw.careconnectpro.model.persona.Persona;

public interface IPersonaDAO {

    boolean insertPersona(PersonaDB p);
    PersonaDB selectPersonaByCf(String cf);
	boolean deletePersona(Persona p);
	List<PersonaDB> selectPazienti();
}
