package co.com.proyectoagendamientocitas.transversal.utilitarios;

import java.util.UUID;

public final class UtilUUID {
	
	public static final String UUID_DEFECTO_TEXTO = "00000000-0000-0000-0000-000000000000";
	
	private UtilUUID() {

	}
	
	public static UUID generar() {
	    return UUID.randomUUID();
    }
	
	public static UUID convertirAUUID(final String UUIDTexto) {
		return UUID.fromString(obtenerValorDefectoComoTexto(UUIDTexto));
	}
		
	public static UUID obtenerValorDefecto(final UUID valor, final UUID valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	
	public static UUID obtenerValorDefecto(final UUID valor) {
		return obtenerValorDefecto(valor, obtenerUUIDDefecto());
	}
	
	 public static UUID obtenerUUIDDefecto() {
	        return convertirAUUID(UUID_DEFECTO_TEXTO);
	}
	 
	 public static String obtenerValorDefectoComoTexto(final String valor) {
		 return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor,UUID_DEFECTO_TEXTO);
	}
	 
}
