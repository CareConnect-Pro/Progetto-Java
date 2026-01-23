package it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.monitoraggio;

import java.util.List;

public interface IMonitoraggioDAO {

	int insertMonitoraggio(MonitoraggioDB tDb);
	List<MonitoraggioDB> selectMonitoraggioByAlertAttivo();
	boolean updateAlertMonitoraggio(MonitoraggioDB mDb);
}
