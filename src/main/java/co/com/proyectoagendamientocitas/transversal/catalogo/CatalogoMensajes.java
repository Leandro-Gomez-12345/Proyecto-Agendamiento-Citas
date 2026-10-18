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

	public static final class Datos {

		private Datos() {

		}

		public static final String USUARIO_ERROR_ABRIENDO_CONEXION = "Se presentó un problema tratando de abrir la conexión con la fuente de información."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_FACTORIA_NO_HABILITADA = "La fuente de información solicitada para llevar a cabo la operación no está habilitada."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_BARBERIA = "Se presentó un problema tratando de crear la información de la barbería."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERIA = "Se presentó un problema tratando de consultar la información de la barbería."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERIA = "Se presentó un problema tratando de actualizar la información de la barbería."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_BARBERIA = "Se presentó un problema tratando de eliminar la información de la barbería."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_DIA_SEMANA = "Se presentó un problema tratando de consultar la información del día de la semana."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO = "Se presentó un problema tratando de consultar la información del departamento."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_ESTADO = "Se presentó un problema tratando de consultar la información del estado."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_ESTADO = "Se presentó un problema tratando de actualizar la información del estado."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_PREFIJO_CELULAR = "Se presentó un problema tratando de consultar la información del prefijo de celular."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_TIPO_MULTA = "Se presentó un problema tratando de consultar la información del tipo de multa."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_FESTIVO = "Se presentó un problema tratando de crear la información del festivo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_FESTIVO = "Se presentó un problema tratando de consultar la información del festivo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_FESTIVO = "Se presentó un problema tratando de actualizar la información del festivo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_FESTIVO = "Se presentó un problema tratando de eliminar la información del festivo."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_CLIENTE = "Se presentó un problema tratando de crear la información del cliente."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_CLIENTE = "Se presentó un problema tratando de consultar la información del cliente."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_CLIENTE = "Se presentó un problema tratando de actualizar la información del cliente."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CONSULTANDO_CIUDAD = "Se presentó un problema tratando de consultar la información de la ciudad."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_SEDE = "Se presentó un problema tratando de crear la información de la sede."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_SEDE = "Se presentó un problema tratando de consultar la información de la sede."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_SEDE = "Se presentó un problema tratando de actualizar la información de la sede."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_SEDE = "Se presentó un problema tratando de eliminar la información de la sede."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_BARBERO = "Se presentó un problema tratando de crear la información del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERO = "Se presentó un problema tratando de consultar la información del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERO = "Se presentó un problema tratando de actualizar la información del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_BARBERO = "Se presentó un problema tratando de eliminar la información del barbero."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_HORARIO_SEDE = "Se presentó un problema tratando de crear la información del horario de la sede."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_HORARIO_SEDE = "Se presentó un problema tratando de consultar la información del horario de la sede."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_HORARIO_SEDE = "Se presentó un problema tratando de actualizar la información del horario de la sede."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_SERVICIO = "Se presentó un problema tratando de crear la información del servicio."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_SERVICIO = "Se presentó un problema tratando de consultar la información del servicio."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_SERVICIO = "Se presentó un problema tratando de actualizar la información del servicio."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_PERIODO_CIERRE = "Se presentó un problema tratando de crear la información del periodo de cierre."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_PERIODO_CIERRE = "Se presentó un problema tratando de consultar la información del periodo de cierre."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_PERIODO_CIERRE = "Se presentó un problema tratando de actualizar la información del periodo de cierre."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_PERIODO_CIERRE = "Se presentó un problema tratando de eliminar la información del periodo de cierre."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_FECHA_FESTIVO = "Se presentó un problema tratando de crear la información de la apertura de un festivo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_FECHA_FESTIVO = "Se presentó un problema tratando de consultar la información de la apertura de un festivo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_FECHA_FESTIVO = "Se presentó un problema tratando de eliminar la información de la apertura de un festivo."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_BARBERO_SERVICIO = "Se presentó un problema tratando de crear la información del servicio del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_BARBERO_SERVICIO = "Se presentó un problema tratando de consultar la información del servicio del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_BARBERO_SERVICIO = "Se presentó un problema tratando de actualizar la información del servicio del barbero."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_BLOQUEO = "Se presentó un problema tratando de crear la información del bloqueo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_BLOQUEO = "Se presentó un problema tratando de consultar la información del bloqueo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_BLOQUEO = "Se presentó un problema tratando de actualizar la información del bloqueo."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_BLOQUEO = "Se presentó un problema tratando de eliminar la información del bloqueo."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_HORARIO_BARBERO = "Se presentó un problema tratando de crear la información del horario del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_HORARIO_BARBERO = "Se presentó un problema tratando de consultar la información del horario del barbero."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_HORARIO_BARBERO = "Se presentó un problema tratando de actualizar la información del horario del barbero."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_AGENDA = "Se presentó un problema tratando de crear la información de la agenda."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_AGENDA = "Se presentó un problema tratando de consultar la información de la agenda."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_CITA = "Se presentó un problema tratando de crear la información de la cita."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_CITA = "Se presentó un problema tratando de consultar la información de la cita."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_CITA = "Se presentó un problema tratando de actualizar la información de la cita."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_CITA_SERVICIO = "Se presentó un problema tratando de crear la información del servicio de la cita."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_CITA_SERVICIO = "Se presentó un problema tratando de consultar la información del servicio de la cita."
				+ CONTACTAR_ADMINISTRADOR;

		public static final String USUARIO_ERROR_CREANDO_MULTA = "Se presentó un problema tratando de crear la información de la multa."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_CONSULTANDO_MULTA = "Se presentó un problema tratando de consultar la información de la multa."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ACTUALIZANDO_MULTA = "Se presentó un problema tratando de actualizar la información de la multa."
				+ CONTACTAR_ADMINISTRADOR;
		public static final String USUARIO_ERROR_ELIMINANDO_MULTA = "Se presentó un problema tratando de eliminar la información de la multa."
				+ CONTACTAR_ADMINISTRADOR;
	}

}
