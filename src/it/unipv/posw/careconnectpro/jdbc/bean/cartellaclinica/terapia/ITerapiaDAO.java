package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

public interface ITerapiaDAO {

	int insertTerapia(TerapiaDB tDb);
	boolean deleteTerapiaById(int id);

}
