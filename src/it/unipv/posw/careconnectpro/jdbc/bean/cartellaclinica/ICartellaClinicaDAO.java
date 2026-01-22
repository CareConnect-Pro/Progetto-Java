package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

public interface ICartellaClinicaDAO {

	int insertCartellaClinica(CartellaClinicaDB ccDb);
	boolean deleteCartellaClinicaByCf(String cf);

}
