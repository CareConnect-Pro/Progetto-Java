package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import java.util.List;

public interface ITerapiaDAO {

	int insertTerapia(TerapiaDB tDb);
	public List<TerapiaDB> getTerapieAttiveOggi();

}
