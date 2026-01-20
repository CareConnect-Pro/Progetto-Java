package it.unipv.posw.careconnectpro.jdbc.bean.persona;

public interface IPersonaDAO {

    boolean insertPersona(PersonaDB p);
    PersonaDB selectPersonaByCf(String cf);
    boolean deletePersonaByCf(String cf);
}
