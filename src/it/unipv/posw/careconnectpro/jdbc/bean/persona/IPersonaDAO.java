package it.unipv.posw.careconnectpro.jdbc.bean.persona;

import it.unipv.posw.careconnectpro.model.persona.Persona;

public interface IPersonaDAO {

    boolean insertPersona(PersonaDB p);
    PersonaDB selectPersonaByCf(String cf);
	boolean deletePersona(Persona p);
}
