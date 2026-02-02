package it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale.Pressione;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale.TipiParametroVitale;

public class StrategyAlert {
    private static Pressione p;

    public static Alert controlla(TipiParametroVitale tipo, String valore){

        if(tipo == TipiParametroVitale.PRESSIONE_ARTERIOSA){
            try{
                p = new Pressione(valore);

                if(p.isCritica()){
                    return Alert.ATTIVO;
                }
                return Alert.INATTIVO;

            } catch(Exception e){
                return Alert.INATTIVO;
            }

        }

        double altriValori = Double.parseDouble(valore);
        switch(tipo){
            case FREQUENZA_CARDIACA:

                if(altriValori > 100 ||  altriValori < 50){
                    return Alert.ATTIVO;
                }
                return Alert.INATTIVO;

            case TEMPERATURA:
                if(altriValori > 37.5 || altriValori < 35.5){
                    return Alert.ATTIVO;
                }
                return Alert.INATTIVO;


            case SATURAZIONE:
                if(altriValori < 95){
                    return Alert.ATTIVO;
                }
                return Alert.INATTIVO;
		default:
			break;
        }

        return null;
    }

}
