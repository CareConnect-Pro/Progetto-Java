package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

public interface ICartellaClinicaDAO {

	boolean insertCartellaClinica(CartellaClinicaDB ccDb);
	boolean deleteCartellaClinicaByCf(String cf);

}
