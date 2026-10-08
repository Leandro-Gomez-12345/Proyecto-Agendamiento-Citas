package co.com.proyectoagendamientocitas.transversal.catalogo;

public final class CatalogoMensajes {

	private static final String CONTACTAR_ADMINISTRADOR = " Por favor intente de nuevo y si el problema persiste "
			+ "contacte al administrador de la aplicación y reporte la novedad.";

	private CatalogoMensajes() {

	}

	public static final class UtilSQL {

		private UtilSQL() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se presentó un problema tratando de validar si la conexión con la fuente de información estaba abierta."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se presentó un problema NO CONTROLADO tratando de validar si la conexión con la fuente de información estaba abierta."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ES_VALIDA = "Se presentó un problema tratando de validar si la conexión con la fuente de información está respondiendo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se presentó un problema tratando de validar si la operación sobre la fuente de información ya estaba iniciada."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se presentó un problema NO CONTROLADO tratando de validar si la operación sobre la fuente de información ya estaba iniciada."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible llevar a cabo la operación deseada porque la conexión con la fuente de información no está abierta."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ES_VALIDA = "La conexión con la fuente de información no está respondiendo."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible iniciar la operación deseada porque ya hay una operación en curso sobre la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION_SQL = "Se presentó un problema tratando de iniciar la operación sobre la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar la operación porque no fue iniciada previamente."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONFIRMANDO_TRANSACCION_SQL = "Se presentó un problema tratando de confirmar los cambios en la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible cancelar la operación porque no fue iniciada previamente."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CANCELANDO_TRANSACCION_SQL = "Se presentó un problema tratando de deshacer los cambios en la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CERRANDO_CONEXION_SQL = "Se presentó un problema tratando de cerrar la conexión con la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
	}
}
